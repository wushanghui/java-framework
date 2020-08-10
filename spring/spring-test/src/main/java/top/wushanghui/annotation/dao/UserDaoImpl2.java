package top.wushanghui.annotation.dao;

import org.springframework.stereotype.Repository;

/**
 * @author jue
 * @date 2020/8/7 10:32
 * @describe
 */
@Repository
public class UserDaoImpl2 implements UserDao{

    @Override
    public void add() {
        System.out.println("UserDaoImpl2 add()");
    }
}
