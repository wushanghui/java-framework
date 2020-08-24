package top.wushanghui;

import java.math.BigDecimal;

/**
 * @author wsh
 * @date 2020/8/18 17:52
 */
public class JavaMain {

    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("6.0000013314E-7");
        System.out.println(bigDecimal);
        System.out.println(bigDecimal.toPlainString());
    }
}
