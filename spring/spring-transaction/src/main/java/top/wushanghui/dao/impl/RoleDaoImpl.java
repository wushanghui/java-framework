package top.wushanghui.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.wushanghui.dao.RoleDao;
import top.wushanghui.dao.UserDao;
import top.wushanghui.entity.Role;
import top.wushanghui.entity.User;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jue
 * @date 2020/8/15 22:54
 * @describe
 */
@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int update(Role role) {
        String sql = "update role set role_name = ?, version = ? where role_code = ? and version = ?";
        Object[] args = {role.getRoleName(), role.getVersion()+1, role.getRoleCode(), role.getVersion()};
        return jdbcTemplate.update(sql, args);
    }

    @Override
    public Role query(String roleCode) {
        String sql = "select * from role where role_code = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Role.class), roleCode);
    }


}
