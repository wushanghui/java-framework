package top.wushanghui.multi.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.wushanghui.multi.bean.MultiBean;
import top.wushanghui.multi.config.MultiConfig;

/**
 * @author jue
 * @date 2020/8/13 21:48
 * @describe
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MultiConfig.class);
        MultiBean multiBean = ctx.getBean(MultiBean.class);
        multiBean.testMulti();
    }
}
