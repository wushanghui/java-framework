package top.wushanghui.aop.annotation.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.wushanghui.aop.annotation.config.AopConfig;
import top.wushanghui.aop.annotation.pojo.Role;
import top.wushanghui.aop.annotation.service.RoleService;
import top.wushanghui.aop.annotation.verifier.RoleVerifier;

/**
 * @author jue
 * @date 2020/8/13 21:48
 * @describe
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AopConfig.class);
        RoleService roleService = ctx.getBean(RoleService.class);
        Role role = new Role(1L, "admin", "note1");
        RoleVerifier roleVerifier = (RoleVerifier) roleService;
        if (roleVerifier.verify(role)) {
            roleService.printRole(role, 2);
        }
        System.out.println("============================");
        // 测试异常通知
        role = null;
        if (roleVerifier.verify(role)) {
            roleService.printRole(role, 2);
        }
        System.out.println("============================");
    }
}
