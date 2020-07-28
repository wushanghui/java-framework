package top.wushanghui.config.service;

import org.springframework.stereotype.Service;
import top.wushanghui.ioc.User;

/**
 * @author wsh
 * @date 2020-07-28 20:44
 */
@Service
public class UserService {

    public User getUser() {
        return new User(1, "韩信", 30);
    }
}
