package top.wushanghui.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author jue
 * @date 2020/8/17 20:40
 * @describe
 */
@Configuration
@ComponentScan("top.wushanghui")
@EnableTransactionManagement
public class JavaConfig implements TransactionManagementConfigurer {

    /**
     * 数据源
     */
    private DataSource dataSource = null;

    /**
     * 配置数据源
     * @return 数据源
     */
    @Bean(name = "dataSource")
    public DataSource initDataSource() {
        if (dataSource != null) {
            return dataSource;
        }

        Properties properties = new Properties();
        properties.setProperty("driverClassName", "com.mysql.cj.jdbc.Driver");
        properties.setProperty("url", "jdbc:mysql:///spring?serverTimezone=UTC");
        properties.setProperty("username", "root");
        properties.setProperty("password", "12345");

        try {
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    /**
     * 配置 jdbcTemplate
     * @return jdbcTemplate
     */
    @Bean("jdbcTemplate")
    public JdbcTemplate initJdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(initDataSource());
        return jdbcTemplate;
    }

    /**
     * 实现接口，使得返回数据库事务管理器
     * @return 事务管理器
     */
    @Override
    @Bean("transactionManager")
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        // 设置事务管理器的数据源
        dataSourceTransactionManager.setDataSource(initDataSource());
        return dataSourceTransactionManager;
    }
}
