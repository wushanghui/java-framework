package top.wushanghui.bean;

/**
 * @author wsh
 * @date 2020/8/6 16:29
 */
public class LifeCycleBean {

    private String name;

    public LifeCycleBean() {
        System.out.println("1、执行无参构造器创建 bean 实例");
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("2、调用set方法设置属性值");
    }

    public void initMethod() {
        System.out.println("3、执行初始化方法");
    }

    public void destroyMethod() {
        System.out.println("5、执行销毁的方法");
    }

}
