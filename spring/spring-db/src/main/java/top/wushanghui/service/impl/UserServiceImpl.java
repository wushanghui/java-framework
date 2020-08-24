package top.wushanghui.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.wushanghui.dao.UserDao;
import top.wushanghui.dao.impl.UserDao2;
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

    @Autowired
    private UserDao2 userDao2;

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
<<<<<<< .mine
    @Transactional(propagation = Propagation.REQUIRED)





=======
    public User getUserByName(String name) {
        return userDao.getUserByName(name);
    }

    @Override
    @Transactional
>>>>>>> .theirs
    public void accountMoney() {
        System.out.println("accountMoney");

        userDao.reduceMoney("小明", 100);
        userDao.addMoney("小红", 100);
        int i = 1 / 0;

    }

    @Override
    public void addMoney() {
        userDao.addMoney("小红", 100);
    }

    @Override
    @Transactional
    public void reduceMoney() {
        userDao.reduceMoney("小明", 100);
    }


}
