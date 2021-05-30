package top.wushanghui;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import top.wushanghui.config.TxConfig;
import top.wushanghui.entity.Role;
import top.wushanghui.entity.User;
import top.wushanghui.service.RoleService;
import top.wushanghui.service.UserService;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author wsh
 * @date 2021/1/27 11:16
 */

@SpringJUnitConfig(TxConfig.class)
public class LockTest {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Test
    public void pessimisticLock() throws InterruptedException {

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                User user = new User(new BigInteger("1"), "Jerry", "1", new BigDecimal("2000"));
                userService.updateByForUpdate(user);
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                // 上来先睡眠1s
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                User user = new User(new BigInteger("1"), "Jerry", "1", new BigDecimal("4000"));
                userService.update(user);
            }
        });


        threadA.start();
        threadB.start();

        threadA.join();
        threadB.join();
        System.out.println("main over!");

    }


    @Test
    public void optimisticLock() throws InterruptedException {

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean result = false;
                int retryNum = 5;
                Role role = new Role("admin", "超级管理员", 1);
                while (retryNum > 0) {
                    int num = roleService.update(role);
                    if (num == 1) {
                        result = true;
                        break;
                    } else {
                        Role query = roleService.query("admin");
                        //
                    }
                }

                int num = roleService.update(role);
                if (num == 0) {
                    throw new RuntimeException("threadA 更新角色失败！");
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                Role role = new Role("admin", "超级管理员Plus", 1);
                int num = roleService.update(role);
                if (num == 0) {
                    throw new RuntimeException("threadB 更新角色失败！");
                }
            }
        });


        threadA.start();
        threadB.start();

        threadA.join();
        threadB.join();
        System.out.println("main over!");

    }
}
