package top.wushanghui.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.wushanghui.config.service.UserService;

/**
 * @author wsh
 * @date 2020-07-28 22:06
 */
public class ConfigTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigClass.class);
        HelloWorld sayHello = (HelloWorld) context.getBean("hello");
        sayHello.hello(); // hello world!
        UserService userService = context.getBean(UserService.class);
        System.out.println(userService.getUser()); // User{id=1, name='韩信', age=30, dog=null, favorites=null, cats=null, map=null, properties=null}

    }
}
