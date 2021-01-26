package top.wushanghui.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.wushanghui.dao.UserDao;
import top.wushanghui.entity.User;
import top.wushanghui.service.UserService;

import java.math.BigDecimal;

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


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, timeout = 1)
    @Override
    public void addAll() {
        User user = new User("小明", "01", new BigDecimal("1000"));
        userDao.add(user);

        for (int i = 0; i < 1000; i++) {
            userService2.addUser2(i);
        }

        //int i = 1/0;
    }
}
