package top.wushanghui;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author wsh
 * @date 2020-08-24 14:35
 */
@RunWith(SpringJUnit4ClassRunner.class) //单元测试框架
@ContextConfiguration("classpath:spring-config.xml") //加载配置文件
public class JUnit4 {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void test() {
        System.out.println(jdbcTemplate);
    }
}
