package top.wushanghui.aop.game;

/**
 * @author jue
 * @date 2020/8/10 22:17
 * @describe
 */
public class RoleInterceptor implements Interceptor {
    @Override
    public void before(Object obj) {
        System.out.println("准备打印角色信息");
    }

    @Override
    public void after(Object obj) {
        System.out.println("已经完成角色信息的打印处理");
    }

    @Override
    public void afterReturning(Object obj) {
        System.out.println("刚刚打印完成，一切正常");
    }

    @Override
    public void afterThrowing(Object obj) {
        System.out.println("打印功能执行异常了，请查看下角色对象是否为空了吗？");
    }
}
