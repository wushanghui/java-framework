package top.wushanghui.annotation;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.wushanghui.annotation.config.AttributeAssignmentConfig;
import top.wushanghui.annotation.entity.Employee;

/**
 * @author jue
 * @date 2021/4/11 13:07
 * @describe
 */
public class AttributeAssignmentTest {

    @Test
    public void testValueAnnotation() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AttributeAssignmentConfig.class);
        Employee employee = context.getBean(Employee.class);
        System.out.println(employee);
    }
}
