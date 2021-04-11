package top.wushanghui.annotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import top.wushanghui.annotation.entity.Red;

/**
 * @author jue
 * @date 2021/4/10 20:47
 * @describe
 */
@ComponentScan("top.wushanghui.annotation.entity")
@Configuration
public class LifeCycleConfig {

//    @Scope("prototype")
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Red red() {
        return new Red();
    }
}
