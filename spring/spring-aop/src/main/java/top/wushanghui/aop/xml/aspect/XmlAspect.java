package top.wushanghui.aop.xml.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import top.wushanghui.aop.xml.pojo.Role;
import top.wushanghui.aop.xml.verifier.RoleVerifier;

/**
 * @author jue
 * @date 2020/8/12 21:35
 * @describe
 */
public class XmlAspect {

    private RoleVerifier roleVerifier;

    public void before(Role role, int sort) {
        System.out.println("before ... role: " + role + ", sort: " + sort);
    }

    public void after() {
        System.out.println("after ... ");
    }

    public void afterReturning() {
        System.out.println("afterReturning ... ");
    }

    public void afterThrowing() {
        System.out.println("afterThrowing ... ");
    }

    public void around(ProceedingJoinPoint joinPoint) {
        System.out.println("around before ... ");
        try {
            joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("around after ... ");
    }
}
