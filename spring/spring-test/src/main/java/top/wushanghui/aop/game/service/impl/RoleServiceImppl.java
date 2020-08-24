package top.wushanghui.aop.game.service.impl;

import top.wushanghui.aop.game.pojo.Role;
import top.wushanghui.aop.game.service.RoleService;

/**
 * @author jue
 * @date 2020/8/10 22:11
 * @describe
 */
public class RoleServiceImppl implements RoleService {

    @Override
    public void printRole(Role role) {
        System.out.println("{id = " + role.getId() + ", roleName = " + role.getRoleName() + ", note = " + role.getNote() + "}");
    }
}
