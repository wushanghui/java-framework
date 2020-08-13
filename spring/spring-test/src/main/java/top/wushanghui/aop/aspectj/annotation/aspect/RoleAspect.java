package top.wushanghui.aop.aspectj.annotation.aspect;

import org.aspectj.lang.annotation.Aspect;

/**
 * @author jue
 * @date 2020/8/12 21:35
 * @describe
 */
@Aspect
public class RoleAspect {
    public void before(Object obj) {
        System.out.println("准备打印角色信息");
    }

    public void after(Object obj) {
        System.out.println("已经完成角色信息的打印处理");
    }

    public void afterReturning(Object obj) {
        System.out.println("刚刚打印完成，一切正常");
    }

    public void afterThrowing(Object obj) {
        System.out.println("打印功能执行异常了，请查看下角色对象是否为空了吗？");
    }
}
