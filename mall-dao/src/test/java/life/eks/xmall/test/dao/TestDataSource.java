package life.eks.xmall.test.dao;

import life.eks.xmall.dao.config.DaoConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import javax.sql.DataSource;

@SpringBootTest(classes = DaoConfiguration.class)
@WebAppConfiguration
@RunWith(SpringRunner.class)
public class TestDataSource {

    @Resource
    private DataSource dataSource;
    @Test
    public void testConnection() throws Exception {
        System.out.println(this.dataSource instanceof com.alibaba.druid.pool.DruidDataSource);
    }
}