package top.wushanghui.annotation;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;
import top.wushanghui.annotation.config.ComponentRegistrationConfig;
import top.wushanghui.annotation.entity.Color;
import top.wushanghui.annotation.entity.Person;
import top.wushanghui.annotation.service.ShowCommand;

/**
 * @author jue
 * @date 2021/4/9 21:51
 * @describe
 */
public class ComponentRegistrationTest {

    private final ApplicationContext context = new AnnotationConfigApplicationContext(ComponentRegistrationConfig.class);


    @Test
    public void testBeanAnnotation() {
        Person person = context.getBean(Person.class);
        System.out.println(person);
        String[] beanNamesForType = context.getBeanNamesForType(Person.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }
        System.out.println("================================漂亮的分隔符================================");
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }

    @Test
    public void testComponentScanAnnotation() {
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }

    @Test
    public void testScopeAnnotation() {
        System.out.println("ioc容器创建完成....");
        Object bean1 = context.getBean("person1");
        Object bean2 = context.getBean("person1");
        System.out.println(bean1 == bean2);
    }

    @Test
    public void testConditionalAnnotation() {
        Environment environment = context.getEnvironment();
        String osName = environment.getProperty("os.name");
        System.out.println(osName);
        ShowCommand showCmd = (ShowCommand) context.getBean("showCmd");
        System.out.println(showCmd.getClass());
        System.out.println(showCmd.showCommandInfo());
    }

    @Test
    public void testImportAnnotation() {
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }

    @Test
    public void testFactoryBean() {
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        System.out.println("================================漂亮的分隔符================================");
        Object bean1 = context.getBean("colorFactoryBean");
        Object bean2 = context.getBean("colorFactoryBean");
        Object bean3 = context.getBean("&colorFactoryBean");
        Object bean4 = context.getBean("&colorFactoryBean");
        System.out.println("bean1.getClass(): " + bean1.getClass());
        System.out.println("bean2.getClass(): " + bean2.getClass());
        System.out.println("bean3.getClass(): " + bean3.getClass());
        System.out.println("bean4.getClass(): " + bean4.getClass());
        System.out.println("color 是否是单例的："+bean1 == bean2);
        System.out.println("FactoryBean 是否是单例的："+bean3 == bean4);
    }


}
