package top.wushanghui.bean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wsh
 * @date 2020/8/4 13:31
 */
public class JavaMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        Book bean = context.getBean(Book.class);
        System.out.println(bean);
    }
}
