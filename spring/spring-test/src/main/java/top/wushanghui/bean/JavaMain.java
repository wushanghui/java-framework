package top.wushanghui.bean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wsh
 * @date 2020/8/4 13:31
 */
public class JavaMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        Book book4 = context.getBean("book", Book.class);
        System.out.println(book4);
    }
}
