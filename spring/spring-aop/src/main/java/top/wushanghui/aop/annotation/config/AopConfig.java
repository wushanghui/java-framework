package top.wushanghui.aop.annotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import top.wushanghui.aop.annotation.aspect.RoleAspect;

/**
 * @author jue
 * @date 2020/8/13 21:46
 * @describe
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("top.wushanghui.aop.annotation")
public class AopConfig {

    @Bean
    public RoleAspect getRoleAspect() {
        return new RoleAspect();
    }
}
