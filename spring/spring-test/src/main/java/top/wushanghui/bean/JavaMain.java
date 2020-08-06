package top.wushanghui.bean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wsh
 * @date 2020/8/4 13:31
 */
public class JavaMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean7.xml");
        Person person = context.getBean("person", Person.class);
        System.out.println(person);
    }
}
