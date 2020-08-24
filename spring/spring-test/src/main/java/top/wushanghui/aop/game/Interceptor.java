package top.wushanghui.aop.game;

/**
 * @author jue
 * @date 2020/8/10 22:01
 * @describe
 */
public interface Interceptor {

    public void before(Object obj);
    public void after(Object obj);
    public void afterReturning(Object obj);
    public void afterThrowing(Object obj);
}
