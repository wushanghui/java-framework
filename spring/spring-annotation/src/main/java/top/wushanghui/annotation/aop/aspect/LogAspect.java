package top.wushanghui.annotation.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * @Aspect： 告诉Spring当前类是一个切面类
 */
@Aspect
public class LogAspect {

    /**
     * 抽取公共的切入点表达式
     * 1、本类引用
     * 2、其他的切面引用
     */
    @Pointcut("execution(public int top.wushanghui.annotation.aop.MathCalculator.*(..))")
    public void pointExpression() {
    }

    /**
     * @Before在目标方法之前切入；切入点表达式（指定在哪个方法切入）
     */
    @Before("pointExpression()")
    public void logStart(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.println(joinPoint.getSignature().getName() + "运行。。。@Before:参数列表是：{" + Arrays.toString(args) + "}");
    }

    @After("top.wushanghui.annotation.aop.aspect.LogAspect.pointExpression()")
    public void logEnd(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + "结束。。。@After");
    }

    /**
     * JoinPoint一定要出现在参数表的第一位
     */
    @AfterReturning(value = "pointExpression()", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result) {
        System.out.println(joinPoint.getSignature().getName() + "正常返回。。。@AfterReturning:运行结果：{" + result + "}");
    }

    @AfterThrowing(value = "pointExpression()", throwing = "exception")
    public void logException(JoinPoint joinPoint, Exception exception) {
        System.out.println(joinPoint.getSignature().getName() + "异常。。。异常信息：{" + exception + "}");
    }
}
