package top.wushanghui.aop.aspect;

import org.springframework.stereotype.Component;

/**
 * @author jue
 * @date 2020/8/10 21:49
 * @describe
 */
@Component
public class User {

    public void add() {
        System.out.println("add.......");
    }
}
