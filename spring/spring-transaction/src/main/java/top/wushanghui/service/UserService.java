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
    public int update(User user);
    public int updateByForUpdate(User user);
    public int delete(BigInteger id);
    public User getOne(BigInteger id);
    public User getOneByForUpdate(BigInteger id);

    void addAll();
}
