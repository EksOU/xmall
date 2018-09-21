package life.eks.xmall.service;

import life.eks.xmall.dao.config.DaoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @author Eks OU
 */
@SpringBootApplication
@Import(DaoConfiguration.class)
public class ServiceGoodsBoot {
    public static void main(String[] args) {
        SpringApplication.run(ServiceGoodsBoot.class, args);
    }
}
