package top.wushanghui.aop.game;

import top.wushanghui.aop.game.pojo.Role;
import top.wushanghui.aop.game.service.RoleService;
import top.wushanghui.aop.game.service.impl.RoleServiceImppl;

/**
 * @author jue
 * @date 2020/8/10 22:19
 * @describe
 */
public class GameMain {

    public static void main(String[] args) {
        RoleService roleService = new RoleServiceImppl();
        RoleInterceptor interceptor = new RoleInterceptor();
        System.out.println("roleService" + roleService);
        RoleService proxy = ProxyBeanFactory.getBean(roleService, interceptor);
        Role role = new Role(1L, "admin", "管理员");
        proxy.printRole(role);
        System.out.println("--------测试--afterThrowing() 方法--------");
        role = null;
        proxy.printRole(role);
    }
}
