package top.wushanghui.aop.annotation.service.impl;


import org.springframework.stereotype.Component;
import top.wushanghui.aop.annotation.pojo.Role;
import top.wushanghui.aop.annotation.service.RoleService;

/**
 * @author jue
 * @date 2020/8/10 22:11
 * @describe
 */
@Component
public class RoleServiceImppl implements RoleService {

    @Override
    public void printRole(Role role, int sort) {
        System.out.println("{id = " + role.getId() + ", roleName = " + role.getRoleName() + ", note = " + role.getNote() + "}");
        System.out.println("sort" + sort);
    }
}
