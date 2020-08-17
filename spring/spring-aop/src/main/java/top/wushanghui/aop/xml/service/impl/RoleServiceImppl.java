package top.wushanghui.aop.xml.service.impl;

import top.wushanghui.aop.xml.pojo.Role;
import top.wushanghui.aop.xml.service.RoleService;

/**
 * @author jue
 * @date 2020/8/10 22:11
 * @describe
 */
public class RoleServiceImppl implements RoleService {

    @Override
    public void printRole(Role role, int sort) {
        System.out.println("{id = " + role.getId() + ", roleName = " + role.getRoleName() + ", note = " + role.getNote() + "}");
        System.out.println("sort" + sort);
    }
}
