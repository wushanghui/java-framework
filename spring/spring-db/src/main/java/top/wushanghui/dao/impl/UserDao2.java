package top.wushanghui.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wsh
 * @date 2020-08-21 15:01
 */
@Repository
public class UserDao2 {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addMoney(String name, Integer money) {
        String sql = "update user set money = money+? where name = ?";
        jdbcTemplate.update(sql, money, name);
    }
}
