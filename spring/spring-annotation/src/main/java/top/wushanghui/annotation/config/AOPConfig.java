package top.wushanghui.annotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import top.wushanghui.annotation.aop.MathCalculator;
import top.wushanghui.annotation.aop.aspect.LogAspect;

/**
 * @author jue
 * @date 2021/4/11 14:15
 * @describe
 */
@EnableAspectJAutoProxy
@Configuration
public class AOPConfig {

    @Bean
    public MathCalculator calculator() {
        return new MathCalculator();
    }

    /**
     * 切面类加入到容器中
     */
    @Bean
    public LogAspect logAspects() {
        return new LogAspect();
    }
}
