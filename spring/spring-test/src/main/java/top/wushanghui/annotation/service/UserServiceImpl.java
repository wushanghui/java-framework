package top.wushanghui.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import top.wushanghui.annotation.dao.UserDao;

import javax.annotation.Resource;

/**
 * @author jue
 * @date 2020/8/6 22:13
 * @describe
 */
@Service
public class UserServiceImpl implements UserService{

//    @Resource(name = "userDaoImpl1")
    @Autowired
//    @Qualifier("userDaoImpl1")
//    @Resource
    private UserDao userDao;

    @Value(value = "abc")
    private String value;

    @Override
    public void add() {
        System.out.println("UserService add() "+value);
        userDao.add();
    }
}
