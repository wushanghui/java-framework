package top.wushanghui.service;

import top.wushanghui.entity.User;

import java.math.BigInteger;
import java.util.List;

/**
 * @author jue
 * @date 2020/8/15 22:52
 * @describe
 */
public interface UserService {

    public int add(User user);
    public int[] batchAdd(List<User> userList);
    public int update(User user);
    public int[] batchUpdate(List<User> userList);
    public int delete(BigInteger id);
    public int[] batchDelete(List<BigInteger> list);
    public User getOne(BigInteger id);
    public List<User> getAll();
    public int queryCount();
    public User getUserByName(String name);
    public void accountMoney();

    public void addMoney();
    public void reduceMoney();
}
