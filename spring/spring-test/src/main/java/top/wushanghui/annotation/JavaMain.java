package top.wushanghui.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.wushanghui.annotation.controller.UserController;

/**
 * @author jue
 * @date 2020/8/6 23:04
 * @describe
 */
public class JavaMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean9.xml");
//        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
//        for (String beanDefinitionName : beanDefinitionNames) {
//            System.out.println(beanDefinitionName);
//        }
        UserController bean = ctx.getBean(UserController.class);
        bean.add();
    }
}
