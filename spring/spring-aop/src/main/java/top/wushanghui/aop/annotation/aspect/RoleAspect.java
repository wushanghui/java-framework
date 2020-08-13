package top.wushanghui.aop.annotation.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import top.wushanghui.aop.annotation.pojo.Role;
import top.wushanghui.aop.annotation.service.impl.RoleServiceImppl;
import top.wushanghui.aop.annotation.verifier.RoleVerifier;
import top.wushanghui.aop.annotation.verifier.impl.RoleVerifierImpl;

/**
 * @author jue
 * @date 2020/8/12 21:35
 * @describe
 */
@Aspect
public class RoleAspect {

    @DeclareParents(value = "top.wushanghui.aop.annotation.service.impl.RoleServiceImppl+", defaultImpl = RoleVerifierImpl.class)
    private RoleVerifier roleVerifier;

    @Pointcut("execution(* top.wushanghui.aop.annotation.service.impl.RoleServiceImppl.printRole(..))")
    public void print() {

    }

    @Before("execution(* top.wushanghui.aop.annotation.service.impl.RoleServiceImppl.printRole(..)) && args(role, sort)")
    public void before(Role role, int sort) {
        System.out.println("before ... role: " + role + ", sort: " + sort);
    }

    @After("print()")
    public void after() {
        System.out.println("after ... ");
    }

    @AfterReturning("print())")
    public void afterReturning() {
        System.out.println("afterReturning ... ");
    }

    @AfterThrowing("print()")
    public void afterThrowing() {
        System.out.println("afterThrowing ... ");
    }

    @Around("print()")
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
