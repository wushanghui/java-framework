package top.wushanghui.annotation.config;

import org.springframework.context.annotation.*;
import top.wushanghui.annotation.entity.Employee;
import top.wushanghui.annotation.entity.Red;

/**
 * @author jue
 * @date 2021/4/10 20:47
 * @describe
 */
//使用@PropertySource读取外部配置文件中的k/v保存到运行的环境变量中;加载完外部的配置文件以后使用${}取出配置文件的值
@PropertySource("classpath:/emp.properties")
@Configuration
public class AttributeAssignmentConfig {


    @Bean
    public Employee getEmployee() {
        return new Employee();
    }
}
