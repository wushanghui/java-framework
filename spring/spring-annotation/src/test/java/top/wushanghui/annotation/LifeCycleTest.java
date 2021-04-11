package top.wushanghui.annotation;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.wushanghui.annotation.config.LifeCycleConfig;
import top.wushanghui.annotation.entity.Green;
import top.wushanghui.annotation.entity.Red;

/**
 * @author jue
 * @date 2021/4/10 20:54
 * @describe
 */
public class LifeCycleTest {

    @Test
    public void initAndDestroy() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        System.out.println("IOC 容器 创建完成...");
        Red red = context.getBean(Red.class);
        System.out.println(red);
        context.close();
        System.out.println("IOC 容器 关闭...");
    }

    @Test
    public void testInitializingBeanAndDisposableBean() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        System.out.println("IOC 容器 创建完成...");
        context.close();
        System.out.println("IOC 容器 关闭...");
    }

    @Test
    public void testPostConstructAndPreDestroy() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        System.out.println("IOC 容器 创建完成...");
        context.close();
        System.out.println("IOC 容器 关闭...");
    }

    @Test
    public void testApplicationContextAware() {
        ApplicationContext context = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        Green bean = context.getBean(Green.class);
        System.out.println(context);
        System.out.println(bean.getApplicationContext());
        System.out.println(context == bean.getApplicationContext());
    }
}
