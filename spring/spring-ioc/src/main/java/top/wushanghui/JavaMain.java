package top.wushanghui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.wushanghui.service.UserService;

/**
 * @author wsh
 * @date 2021/3/10 16:18
 */
public class JavaMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:application.xml");
        System.out.println("applicationContext 启动成功");
        UserService userService = applicationContext.getBean(UserService.class);

        System.out.println(userService.getUserName());
    }
}
