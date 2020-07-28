package top.wushanghui.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author wsh
 * @date 2020-07-28 20:43
 */
@Configuration
@ComponentScan("top.wushanghui.config.service")
public class ConfigClass {

    @Bean("hello")
    public HelloWorld sayHello() {
        return new HelloWorld();
    }
}
