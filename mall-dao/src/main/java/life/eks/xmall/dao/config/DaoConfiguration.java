package life.eks.xmall.dao.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Eks OU
 */
@SpringBootApplication
@MapperScan("life.eks.xmall")
public class DaoConfiguration {
}
