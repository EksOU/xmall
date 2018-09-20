package life.eks.xmall.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Eks OU
 */
@SpringBootApplication
//@Import(DaoConfiguration.class)
@MapperScan("life.eks.xmall")
public class ServiceGoodsBoot {

    public static void main(String[] args) {
        SpringApplication.run(ServiceGoodsBoot.class, args);
    }
}
