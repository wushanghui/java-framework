package top.wushanghui.annotation.dao;

import org.springframework.stereotype.Repository;

/**
 * @author jue
 * @date 2020/8/6 22:12
 * @describe
 */
@Repository
public class UserDao {

    public void add() {
        System.out.println("UserDao add()");
    }
}
