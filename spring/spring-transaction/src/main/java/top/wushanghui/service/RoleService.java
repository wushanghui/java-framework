package top.wushanghui.service;

import top.wushanghui.entity.Role;
import top.wushanghui.entity.User;

import java.math.BigInteger;

/**
 * @author jue
 * @date 2020/8/15 22:52
 * @describe
 */
public interface RoleService {

    public int update(Role user);
    public Role query(String roleCode);
}
