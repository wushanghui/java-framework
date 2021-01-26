package top.wushanghui;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import top.wushanghui.config.TxConfig;
import top.wushanghui.service.UserService;

/**
 * @author wsh
 * @date 2021/1/26 13:14
 */

@SpringJUnitConfig(TxConfig.class)
public class TransactionTest {

    @Autowired
    private UserService userService;

    @Test
    public void test() {
        userService.addAll();
    }
}
