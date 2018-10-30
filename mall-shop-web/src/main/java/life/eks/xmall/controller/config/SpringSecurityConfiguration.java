package life.eks.xmall.controller.config;

import com.alibaba.dubbo.config.annotation.Reference;
import life.eks.xmall.api.seller.SellerService;
import life.eks.xmall.dto.SellerDto;
import life.eks.xmall.pojo.Seller;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Eks OU
 * spring security 配置
 */
@Configuration
public class SpringSecurityConfiguration {

    @Reference(version = "1.0.0")
    private SellerService sellerService;

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            Seller seller = sellerService.findById(username);
            if (Objects.isNull(seller) || !Objects.equals(SellerDto.STATUS_PAST, seller.getStatus())) {
                return null;
            }

            List<GrantedAuthority> grantAuthority = new ArrayList<>();
            grantAuthority.add(new SimpleGrantedAuthority("ROLE_SELLER"));
            return new User(username, seller.getPassword(), grantAuthority);
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public ConfigurableServletWebServerFactory webServerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        ErrorPage errorPage403 = new ErrorPage(HttpStatus.FORBIDDEN, "/403.html");
        factory.addErrorPages(errorPage403);
        return factory;
    }

    @Configuration
    public static class FormLoginWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests().antMatchers("/*.html", "/css/**", "/img/**", "/js/**", "/plugins/**", "/seller/register").permitAll()
                    .anyRequest().hasRole("SELLER")
                    .and().formLogin().loginPage("/shoplogin.html").loginProcessingUrl("/login").defaultSuccessUrl("/admin/index.html", true).permitAll()
                    .and().logout().logoutUrl("/logout").permitAll()
                    .and().headers().frameOptions().sameOrigin()
                    .and().csrf().disable();
        }
    }
}
