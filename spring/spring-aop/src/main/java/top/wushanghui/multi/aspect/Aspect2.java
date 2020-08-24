package top.wushanghui.multi.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

/**
 * @author jue
 * @date 2020/8/13 23:02
 * @describe
 */
@Aspect
@Order(1)
public class Aspect2 {

    @Pointcut("execution(* top.wushanghui.multi.bean.impl.MultiBeanImpl.testMulti(..))")
    public void print() {

    }

    @Before("print()")
    public void before() {
        System.out.println("before 2 ... ");
    }

    @After("print()")
    public void after() {
        System.out.println("after 2 ... ");
    }

    @AfterReturning("print())")
    public void afterReturning() {
        System.out.println("afterReturning 2 ... ");
    }

    @AfterThrowing("print()")
    public void afterThrowing() {
        System.out.println("afterThrowing 2 ... ");
    }
}
