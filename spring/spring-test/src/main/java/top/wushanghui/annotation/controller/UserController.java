package top.wushanghui.annotation.controller;

import org.springframework.stereotype.Controller;
import top.wushanghui.annotation.service.UserService;

import javax.annotation.Resource;

/**
 * @author jue
 * @date 2020/8/6 22:12
 * @describe
 */
@Controller
public class UserController {

    @Resource
    private UserService userService;

    public void add() {
        System.out.println("UserController add()");
        userService.add();
    }
}
