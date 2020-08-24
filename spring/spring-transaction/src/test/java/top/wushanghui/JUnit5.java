package top.wushanghui;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author wsh
 * @date 2020-08-24 14:35
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:spring-config.xml") //加载配置文件
public class JUnit5 {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void test() {
        System.out.println(jdbcTemplate);
    }
}
