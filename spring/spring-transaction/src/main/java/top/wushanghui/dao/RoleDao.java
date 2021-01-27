package top.wushanghui.dao;

import top.wushanghui.entity.Role;
import top.wushanghui.entity.User;

import java.math.BigInteger;
import java.util.List;

/**
 * @author jue
 * @date 2020/8/15 22:54
 * @describe
 */
public interface RoleDao {

    public int update(Role user);

    public Role query(String roleCode);
}
