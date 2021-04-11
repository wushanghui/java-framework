package top.wushanghui.annotation;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.wushanghui.annotation.aop.MathCalculator;
import top.wushanghui.annotation.config.AOPConfig;
import top.wushanghui.annotation.entity.Red;

/**
 * @author jue
 * @date 2021/4/10 20:54
 * @describe
 */
public class AOPTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AOPConfig.class);
        System.out.println("IOC 容器 创建完成...");
        MathCalculator m = context.getBean(MathCalculator.class);
        int num = m.div(4, 0);
        System.out.println(num);
        context.close();
        System.out.println("IOC 容器 关闭...");
    }
}
