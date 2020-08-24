package top.wushanghui.aop.aspectj.annotation.service.impl;

import org.springframework.stereotype.Component;
import top.wushanghui.aop.aspectj.annotation.service.RoleService;
import top.wushanghui.aop.game.pojo.Role;

/**
 * @author jue
 * @date 2020/8/10 22:11
 * @describe
 */
@Component
public class RoleServiceImppl implements RoleService {

    @Override
    public void printRole(Role role) {
        System.out.println("{id = " + role.getId() + ", roleName = " + role.getRoleName() + ", note = " + role.getNote() + "}");
    }
}
