package top.wushanghui.annotation.aop;

/**
 * @author jue
 * @date 2021/4/11 14:22
 * @describe
 */
public class MathCalculator {

    public int div(int i, int j) {
        System.out.println("MathCalculator...div...");
        return i / j;
    }
}
