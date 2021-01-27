package top.wushanghui.dao;

import top.wushanghui.entity.User;

import java.math.BigInteger;
import java.util.List;

/**
 * @author jue
 * @date 2020/8/15 22:54
 * @describe
 */
public interface UserDao {

    public int add(User user);
    public int[] batchAdd(List<User> userList);
    public int update(User user);
    public int[] batchUpdate(List<User> userList);
    public int delete(BigInteger id);
    public int[] batchDelete(List<BigInteger> list);
    public User getOne(BigInteger id);
    public User getOneByForUpdate(BigInteger id);
    public List<User> getAll();
    public int queryCount();

    void reduceMoney(String name, Integer money);

    void addMoney(String name, Integer money);
    void addMoney2(String name, Integer money);

    User getUserByName(String name);
}
