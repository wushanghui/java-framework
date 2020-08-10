package top.wushanghui.aop;

/**
 * @author jue
 * @date 2020/8/9 16:40
 * @describe
 */
public class UserDaoImpl implements UserDao {

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public String update(String id) {
        return id;
    }
}
