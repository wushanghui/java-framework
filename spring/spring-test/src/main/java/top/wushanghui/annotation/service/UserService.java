package top.wushanghui.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import top.wushanghui.annotation.dao.UserDao;

import javax.annotation.Resource;

/**
 * @author jue
 * @date 2020/8/6 22:13
 * @describe
 */

public interface UserService {

    public void add();
}
