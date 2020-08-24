package top.wushanghui.aop.annotation.aspect;

import org.aspectj.lang.annotation.*;

/**
 * @author jue
 * @date 2020/8/12 21:35
 * @describe
 */
@Aspect
public class RoleAspect2 {

    @Before("execution(* top.wushanghui.aop.annotation.service.impl.RoleServiceImppl.printRole(..))")
    public void before() {
        System.out.println("before ... ");
    }

    @After("execution(* top.wushanghui.aop.annotation.service.impl.RoleServiceImppl.printRole(..))")
    public void after() {
        System.out.println("after ... ");
    }

    @AfterReturning("execution(* top.wushanghui.aop.annotation.service.impl.RoleServiceImppl.printRole(..))")
    public void afterReturning() {
        System.out.println("afterReturning ... ");
    }

    @AfterThrowing("execution(* top.wushanghui.aop.annotation.service.impl.RoleServiceImppl.printRole(..))")
    public void afterThrowing() {
        System.out.println("afterThrowing ... ");
    }
}
