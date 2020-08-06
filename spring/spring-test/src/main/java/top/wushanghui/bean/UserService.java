package top.wushanghui.bean;

/**
 * @author wsh
 * @date 2020/8/5 11:36
 */
public class UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add() {
        System.out.println("UserService add()");
        userDao.add();
    }
}
