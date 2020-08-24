package top.wushanghui.multi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import top.wushanghui.multi.aspect.Aspect1;
import top.wushanghui.multi.aspect.Aspect2;
import top.wushanghui.multi.aspect.Aspect3;

/**
 * @author jue
 * @date 2020/8/13 21:46
 * @describe
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("top.wushanghui.multi")
public class MultiConfig {

    @Bean
    public Aspect1 getAspect1() {
        return new Aspect1();
    }

    @Bean
    public Aspect2 getAspect2() {
        return new Aspect2();
    }

    @Bean
    public Aspect3 getAspect3() {
        return new Aspect3();
    }
}
