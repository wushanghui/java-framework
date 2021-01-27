package top.wushanghui;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import top.wushanghui.config.TxConfig;
import top.wushanghui.entity.User;
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

    @Test
    public void pessimisticLock() throws InterruptedException {

//        // 初始化工作 插入一个用户
//        Thread threadA = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                User user = new User(new BigInteger("1"), "Jerry", "1", new BigDecimal("1000"));
//                // 先删除
//                userService.delete(user.getId());
//
//                // 然后添加
//                userService.add(user);
//            }
//        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                User user = new User(new BigInteger("1"), "Jerry", "1", new BigDecimal("2000"));
                userService.updateByForUpdate(user);
            }
        });

        Thread threadC = new Thread(new Runnable() {
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

        //threadA.start();
        // 等待threadA做完初始化工作
        //threadA.join();

        threadB.start();
        threadC.start();

        threadB.join();
        threadC.join();
        System.out.println("main over!");

    }
}
