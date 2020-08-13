package top.wushanghui.multi.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

/**
 * @author jue
 * @date 2020/8/13 23:02
 * @describe
 */
@Aspect
@Order(3)
public class Aspect3 {

    @Pointcut("execution(* top.wushanghui.multi.bean.impl.MultiBeanImpl.testMulti(..))")
    public void print() {

    }

    @Before("print()")
    public void before() {
        System.out.println("before 3 ... ");
    }

    @After("print()")
    public void after() {
        System.out.println("after 3 ... ");
    }

    @AfterReturning("print())")
    public void afterReturning() {
        System.out.println("afterReturning 3 ... ");
    }

    @AfterThrowing("print()")
    public void afterThrowing() {
        System.out.println("afterThrowing 3 ... ");
    }
}
