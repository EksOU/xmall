package life.eks.xmall.controller.config;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @author Eks OU
 * spring security 配置
 */
@Configuration
public class SpringSecurityConfigure {
    @Bean
    public UserDetailsService userDetailsService() {
        User.UserBuilder users = User.withDefaultPasswordEncoder();
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(users.username("user").password("123456").roles("USER").build());
        manager.createUser(users.username("admin").password("123456").roles("USER", "ADMIN").build());
        return manager;
    }


    @Bean
    public ConfigurableServletWebServerFactory webServerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        ErrorPage errorPage403 = new ErrorPage(HttpStatus.FORBIDDEN, "/403.html");
        factory.addErrorPages(errorPage403);
        return factory;
    }

    @Configuration
    @Order(1)
    public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.antMatcher("/api/**")
                    .authorizeRequests()
                    .anyRequest().hasRole("ADMIN");
        }
    }

    @Configuration
    public static class FormLoginWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests().antMatchers("/*.html", "/css/**", "/img/**", "/js/**", "/plugins/**").permitAll()
                    .anyRequest().authenticated()
                    .and().formLogin().loginPage("/login.html").loginProcessingUrl("/login").defaultSuccessUrl("/admin/index.html", true).permitAll()
                    .and().logout().logoutUrl("/logout").permitAll()
                    .and().headers().frameOptions().sameOrigin()
                    .and().csrf().disable();
        }
    }
}
