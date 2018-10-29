package life.eks.xmall.controller.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Eks OU
 */
@SpringBootApplication
@ComponentScan("life.eks.xmall.controller")
public class WebShopBoot {
    public static void main(String[] args) {
        SpringApplication.run(WebShopBoot.class, args);
    }
}
