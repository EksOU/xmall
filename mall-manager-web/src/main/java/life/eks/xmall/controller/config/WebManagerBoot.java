package life.eks.xmall.controller.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

/**
 * 启动器
 *
 * @author Eks OU
 */
@SpringBootApplication
@ComponentScan("life.eks.xmall.controller")
public class WebManagerBoot {

    @Bean
    public HttpMessageConverters getFastJsonHttpMessageConverters() {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        converter.setSupportedMediaTypes(fastMediaTypes);
        return new HttpMessageConverters(converter);
    }

    public static void main(String[] args) {
        SpringApplication.run(WebManagerBoot.class, args);
    }
}
