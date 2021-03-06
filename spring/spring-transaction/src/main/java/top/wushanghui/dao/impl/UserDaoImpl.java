package top.wushanghui.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.wushanghui.dao.UserDao;
import top.wushanghui.entity.User;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jue
 * @date 2020/8/15 22:54
 * @describe
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(User user) {
        String sql = "insert into user(name, status, money) values(?,?,?)";
        Object[] args = {user.getName(), user.getStatus(), user.getMoney()};
        return jdbcTemplate.update(sql, args);
    }

    @Override
    public int[] batchAdd(List<User> userList) {
        List<Object[]> list = new ArrayList<>();
        userList.forEach(u -> list.add(new Object[]{u.getName(), u.getStatus(), u.getMoney()}));
        String sql = "insert into user(name, status, money) values(?,?,?)";
        return jdbcTemplate.batchUpdate(sql, list);
    }

    @Override
    public int update(User user) {
        String sql = "update user set name = ?, status = ?, money = ? where id = ?";
        Object[] args = {user.getName(), user.getStatus(), user.getMoney(), user.getId()};
        return jdbcTemplate.update(sql, args);
    }

    @Override
    public int[] batchUpdate(List<User> userList) {
        String sql = "update user set name = ?, status = ?, money = ? where id = ?";
        List<Object[]> list = new ArrayList<>();
        userList.forEach(u -> list.add(new Object[]{u.getName(), u.getStatus(), u.getMoney(), u.getId()}));
        return jdbcTemplate.batchUpdate(sql, list);
    }

    @Override
    public int delete(BigInteger id) {
        String sql = "delete from user where id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public int[] batchDelete(List<BigInteger> ids) {
        String sql = "delete from user where id = ?";
        List<Object[]> list = new ArrayList<>();
        ids.forEach(i -> list.add(new Object[]{i}));
        return jdbcTemplate.batchUpdate(sql, list);
    }

    @Override
    public User getOne(BigInteger id) {
        String sql = "select * from user where id = ?";
        //调用方法
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
    }

    @Override
    public User getOneByForUpdate(BigInteger id) {
        String sql = "select * from user where id = ? for update";
        //调用方法
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
    }

    @Override
    public List<User> getAll() {
        String sql = "select * from user";
        //调用方法
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public int queryCount() {
        String sql = "select count(*) from user";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    @Transactional(propagation = Propagation.NESTED)
    public void reduceMoney(String name, Integer money) {
        String sql = "update user set money = money-? where name = ?";
        jdbcTemplate.update(sql, money, name);
        System.out.println("reduceMoney");

    }

    @Override
    @Transactional(propagation = Propagation.NESTED)
    public void addMoney(String name, Integer money) {
        String sql = "update user set money = money+? where name = ?";
        jdbcTemplate.update(sql, money, name);
        int i = 1 / 0;

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addMoney2(String name, Integer money) {
        String sql = "update account set money = money+? where name = ?";
        jdbcTemplate.update(sql, money, name);
        System.out.println("addMoney2");
    }

    @Override
    public User getUserByName(String name) {
        String sql = "select * from user where name = ?";
        //调用方法
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), name);
    }
}
