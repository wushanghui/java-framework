package top.wushanghui.main;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;
import top.wushanghui.entity.User;
import top.wushanghui.service.UserService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wsh
 * @date 2020-08-21 12:22
 */
public class TransactionTest {

    private UserService userService;

    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        userService = ctx.getBean(UserService.class);
    }

    @Test
    public void insertTestData() {
        List<User> userList = new ArrayList<>();
        userList.add(new User("小明", "0", new BigDecimal("1000")));
        userList.add(new User("小红", "0", new BigDecimal("1000")));
        int[] ints = userService.batchAdd(userList);
        System.out.println("批量添加: " + Arrays.toString(ints));
    }

    @Test
    public void updateTestData() {
        User user1 = userService.getUserByName("小明");
        user1.setMoney(new BigDecimal("1000"));
        User user2 = userService.getUserByName("小红");
        user2.setMoney(new BigDecimal("1000"));
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        int[] ints = userService.batchUpdate(userList);
        System.out.println("批量更新: " + Arrays.toString(ints));
    }

    @Test
    public void test1() {
        userService.accountMoney();
    }

    @Test
    @Transactional
    public void test2() {
        userService.reduceMoney();
        int i = 1 / 0;
        userService.addMoney();
    }
}
