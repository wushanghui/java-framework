package top.wushanghui.annotation.entity;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author jue
 * @date 2021/4/10 19:04
 * @describe
 */
public class ColorFactoryBean implements FactoryBean<Color> {

    /**
     * 回一个Color对象，这个对象会添加到容器中
     */
    @Override
    public Color getObject() throws Exception {
        System.out.println("ColorFactoryBean...create object and return obj...");
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    // 如果不重写，默认是true，单实例的
    //true：这个bean是单实例，在容器中保存一份
    //false：多实例，每次获取都会创建一个新的bean；
    @Override
    public boolean isSingleton() {
        return false;
    }
}
