package top.wushanghui.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author wsh
 * @date 2020/8/6 12:52
 */
public class MyBean implements FactoryBean<Course> {

    @Override
    public Course getObject() throws Exception {
        Course course = new Course();
        course.setName("数学");
        return course;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
