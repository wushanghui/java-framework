package top.wushanghui.annotation.component;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author jue
 * @date 2021/4/6 22:13
 * @describe
 */
public class ComponentScanMain {

    private static final ApplicationContext APPLICATION_CONTEXT = new AnnotationConfigApplicationContext(ComponentScanConfig.class);

    public static void main(String[] args) {
        String[] beanDefinitionNames = APPLICATION_CONTEXT.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }
}
