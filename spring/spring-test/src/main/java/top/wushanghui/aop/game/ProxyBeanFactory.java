package top.wushanghui.aop.game;

import sun.java2d.opengl.OGLContext;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author jue
 * @date 2020/8/10 22:04
 * @describe
 */
public class ProxyBeanFactory {

    public static <T> T getBean(T obj, Interceptor interceptor) {
        return (T) ProxyBeanUtil.getBean(obj, interceptor);
    }
}

class ProxyBeanUtil implements InvocationHandler {

    //被代理对象
    private Object obj = null;

    // 拦截器
    private Interceptor interceptor = null;

    /**
     * 获取动态代理对象
     *
     * @param obj         被代理对象
     * @param interceptor 拦截器
     * @return 动态代理对象
     */
    public static Object getBean(Object obj, Interceptor interceptor) {
        // 使用当前类，作为代理方法，此时被代理对象执行方法的时候，会进入当前类的invoke方法里
        ProxyBeanUtil _this = new ProxyBeanUtil();
        // 保存被代理对象
        _this.obj = obj;
        // 保存拦截器
        _this.interceptor = interceptor;
        // 生成代理对象，并绑定代理方法
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), _this);
    }

    /**
     * 代理方法
     *
     * @param proxy  代理对象
     * @param method 当前调度方法
     * @param args   参数
     * @return 方法返回
     * @throws Throwable 异常
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object retObj = null;
        boolean exceptionFlag = false;
        interceptor.before(obj);
        try {
            // 反射原有方法
            retObj = method.invoke(obj, args);
            System.out.println("retObj try " + retObj);
        } catch (Exception e) {
            exceptionFlag = true;
        } finally {
            interceptor.after(obj);
            System.out.println("retObj, finally. " + retObj);
        }
        if (exceptionFlag) {
            interceptor.afterThrowing(obj);
        } else {
            interceptor.afterReturning(obj);
        }
        return retObj;
    }
}
