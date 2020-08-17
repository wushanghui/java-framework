package top.wushanghui.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.wushanghui.dao.UserDao;
import top.wushanghui.entity.User;
import top.wushanghui.service.UserService;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 * @author jue
 * @date 2020/8/15 22:52
 * @describe
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int add(User user) {
        return userDao.add(user);
    }

    @Override
    public int[] batchAdd(List<User> list) {
        return userDao.batchAdd(list);
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }

    @Override
    public int[] batchUpdate(List<User> userList) {
        return userDao.batchUpdate(userList);
    }

    @Override
    public int delete(BigInteger id) {
        return userDao.delete(id);
    }

    @Override
    public int[] batchDelete(List<BigInteger> list) {
        return userDao.batchDelete(list);
    }

    @Override
    public User getOne(BigInteger id) {
        return userDao.getOne(id);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public int queryCount() {
        return userDao.queryCount();
    }

    @Override
    @Transactional()
    public void accountMoney() {
        //lucy 少 100
        userDao.reduceMoney();
        int i = 1 / 0;
        //mary 多 100
        userDao.addMoney();
    }
}
