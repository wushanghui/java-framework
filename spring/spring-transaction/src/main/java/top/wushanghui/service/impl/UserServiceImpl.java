package top.wushanghui.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.wushanghui.dao.UserDao;
import top.wushanghui.entity.User;
import top.wushanghui.service.UserService;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author jue
 * @date 2020/8/15 22:52
 * @describe
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserService2 userService2;

    @Autowired
    private UserDao userDao;

    @Override
    public int add(User user) {
        return userDao.add(user);
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int updateByForUpdate(User user) {
        userDao.getOneByForUpdate(new BigInteger("1"));
        user.setMoney(new BigDecimal("2000"));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userDao.update(user);
    }

    @Override
    public int delete(BigInteger id) {
        return userDao.delete(id);
    }

    @Override
    public User getOne(BigInteger id) {
        return userDao.getOne(id);
    }

    @Override
    public User getOneByForUpdate(BigInteger id) {
        return null;
    }


    //@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, timeout = 1)
    @Override
    public void addAll() {
        addUserPrivateMethod();

        for (int i = 0; i < 1000; i++) {
            userService2.addUser2(i);
        }

        //int i = 1/0;
    }

    private void addUserPrivateMethod() {
        User user = new User("小明", "01", new BigDecimal("1000"));
        userDao.add(user);
    }


}
