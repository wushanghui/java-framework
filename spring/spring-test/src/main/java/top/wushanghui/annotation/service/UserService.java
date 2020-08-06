package top.wushanghui.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.wushanghui.annotation.dao.UserDao;

/**
 * @author jue
 * @date 2020/8/6 22:13
 * @describe
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public void add() {
        System.out.println("UserService add()");
        userDao.add();
    }
}
