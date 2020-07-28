package top.wushanghui.condition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wsh
 * @date 2020-07-28 22:35
 */
public class JavaMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);

        ShowCmd showCmd = (ShowCmd) context.getBean("showCmd");
        System.out.println(showCmd.showCmd());

    }
}
