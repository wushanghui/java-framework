package top.wushanghui.aop.xml.main;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.wushanghui.aop.xml.pojo.Role;
import top.wushanghui.aop.xml.service.RoleService;
import top.wushanghui.aop.xml.verifier.RoleVerifier;

/**
 * @author jue
 * @date 2020/8/13 21:48
 * @describe
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-aop.xml");
        RoleService roleService = ctx.getBean(RoleService.class);
        Role role = new Role(2L, "admin", "note1");
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
