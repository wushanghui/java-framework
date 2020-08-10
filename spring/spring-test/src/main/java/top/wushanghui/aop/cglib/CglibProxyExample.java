package top.wushanghui.aop.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author jue
 * @date 2020/8/10 21:25
 * @describe
 */
public class CglibProxyExample implements MethodInterceptor {

    /**
     * 生成 CGLIB 代理对象
     * @param cls Class 类
     * @return Class 类的 CGLIB 代理对象
     */
    public Object getProxy(Class cls) {
        //CGLIB enhancer 增强类对象
        Enhancer enhancer = new Enhancer();
        //设置超类地的类型
        enhancer.setSuperclass(cls);
        //定义代理逻辑对象为当前对象，要求当前对象实现 MethodInterceptor 方法
        enhancer.setCallback(this);
        //生成并返回代理对象
        return enhancer.create();
    }

    /**
     * 代理逻辑方法
     * @param proxy 代理对象
     * @param method 方法
     * @param args 方法参数
     * @param methodProxy 方法代理
     * @return 代理逻辑返回
     * @throws Throwable 异常
     */
    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.err.println("调用真实对象前....");
        //CGLIB 反射调用真实对象方法
        Object result = methodProxy.invokeSuper(proxy, args);
        System.err.println("调用真实对象后....");
        return result;
    }
}
