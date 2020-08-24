package top.wushanghui.aop.cglib;

/**
 * @author jue
 * @date 2020/8/10 21:27
 * @describe
 */
public class TestCglibProxy {

    public static void main(String[] args) {
        CglibProxyExample cglib = new CglibProxyExample();
        SayHelloImpl proxyObj = (SayHelloImpl) cglib.getProxy(SayHelloImpl.class);
        proxyObj.sayHello("小明");
    }
}
