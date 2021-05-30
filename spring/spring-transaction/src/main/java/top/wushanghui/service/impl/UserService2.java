package top.wushanghui.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.wushanghui.dao.UserDao;
import top.wushanghui.entity.User;

import java.math.BigDecimal;

/**
 * @author wsh
 * @date 2021/1/26 14:40
 */
@Service
public class UserService2 {

    @Autowired
    private UserDao userDao;

    @Transactional
    public int addUser2(int i) {
        User user = new User("小红", "01", new BigDecimal("2000"));

        if (i == 100) {
            throw new RuntimeException("出错了");
        }

        return userDao.add(user);
    }
}
