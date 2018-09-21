package life.eks.xmall.dao.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Eks OU
 */
@SpringBootApplication
@MapperScan("life.eks.xmall.dao")
public class DaoConfiguration {

    @Bean(name = "druidProp")
    public PropertiesFactoryBean getDruidPropFactoryBean() {
        PropertiesFactoryBean factoryBean = new PropertiesFactoryBean();
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource resource = resolver.getResource("classpath:druid.properties");
        factoryBean.setLocation(resource);
        return factoryBean;
    }

    @Bean
    public DataSource getDataSource(Properties druidProp) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.configFromPropety(druidProp);
        return dataSource;
    }

    @Bean
    public SqlSessionFactoryBean getSqlSessionFactoryBean(DataSource dataSource) throws IOException {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("classpath:life/eks/xmall/dao/mapper/*.xml");
        factoryBean.setMapperLocations(resources);
        factoryBean.setTypeAliasesPackage("life.eks.xmall.pojo");
        return factoryBean;
    }
}
