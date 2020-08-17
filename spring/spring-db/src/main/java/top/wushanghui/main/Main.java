package top.wushanghui.main;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import top.wushanghui.entity.User;
import top.wushanghui.service.UserService;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jue
 * @date 2020/8/15 23:43
 * @describe
 */
public class Main {

    private UserService userService;

    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        userService = ctx.getBean(UserService.class);
    }

    /**
     * 单条数据添加
     */
    @Test
    public void testAdd() {
        int num = userService.add(new User("Tom", "0", new BigDecimal("1000")));
        System.out.println("新增个数：" + num);
    }

    /**
     * 批量添加
     */
    @Test
    public void testBatchAdd() {
        List<User> userList = new ArrayList<>();
        userList.add(new User("小红", "0", new BigDecimal("1000")));
        userList.add(new User("小明", "0", new BigDecimal("1000")));
        int[] ints = userService.batchAdd(userList);
        System.out.println("批量添加: " + Arrays.toString(ints));
    }

    /**
     * 单条数据更新
     */
    @Test
    public void testUpdate() {
        User user = new User(new BigInteger("7"), "Tom", "1", new BigDecimal("2000"));
        int num = userService.update(user);
        System.out.println("更新个数：" + num);
    }

    /**
     * 批量更新
     */
    @Test
    public void testBatchUpdate() {
        List<User> userList = new ArrayList<>();
        userList.add(new User(new BigInteger("8"), "批量添加1", "1", new BigDecimal("3000")));
        userList.add(new User(new BigInteger("9"), "批量添加2", "1", new BigDecimal("3000")));
        int[] ints = userService.batchUpdate(userList);
        System.out.println("批量更新: " + Arrays.toString(ints));
    }

    /**
     * 单条数据删除
     */
    @Test
    public void testDelete() {
        int delete = userService.delete(new BigInteger("7"));
        System.out.println("删除个数：" + delete);
    }

    /**
     * 批量数据删除
     */
    @Test
    public void testBatchDelete() {
        List<BigInteger> list = new ArrayList<>();
        list.add(new BigInteger("8"));
        list.add(new BigInteger("9"));
        int[] ints = userService.batchDelete(list);
        System.out.println("批量删除: " + Arrays.toString(ints));
    }

    /**
     * 获取单条数据
     */
    @Test
    public void testGetOne() {
        User user = userService.getOne(new BigInteger("9"));
        System.out.println(user);
    }

    /**
     * 获取全部数据
     */
    @Test
    public void testGetAll() {
        List<User> all = userService.getAll();
        System.out.println(all);
    }

    /**
     * 全部条数
     */
    @Test
    public void queryCount() {
        int count = userService.queryCount();
        System.out.println("num：" + count);
    }

    @Test
    public void testTransaction() {
        userService.accountMoney();
    }

    @Test
    public void testTransaction1() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        JdbcTemplate jdbcTemplate = ctx.getBean(JdbcTemplate.class);
        // 事务定义类
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        PlatformTransactionManager transactionManager = ctx.getBean(PlatformTransactionManager.class);
        TransactionStatus status = transactionManager.getTransaction(def);
        try {
            jdbcTemplate.update("insert into user(name, status, money) values('程序员','0','5000')");
            int i = 1 / 0;
            // 提交事务
            transactionManager.commit(status);
        } catch (Exception e) {
            e.printStackTrace();
            // 回滚事务
            transactionManager.rollback(status);
        }
    }


}
