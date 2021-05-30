package top.wushanghui.annotation.config;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import top.wushanghui.annotation.condition.LinuxCondition;
import top.wushanghui.annotation.condition.MyImportBeanDefinitionRegistrar;
import top.wushanghui.annotation.condition.MyImportSelector;
import top.wushanghui.annotation.condition.WindowsCondition;
import top.wushanghui.annotation.entity.ColorFactoryBean;
import top.wushanghui.annotation.entity.Dog;
import top.wushanghui.annotation.entity.Person;
import top.wushanghui.annotation.service.ShowCommand;
import top.wushanghui.annotation.service.impl.LinuxShowCommand;
import top.wushanghui.annotation.service.impl.WindowsShowCommand;

/**
 * @author jue
 * @date 2021/4/9 21:54
 * @describe
 */
//@ComponentScan(value = {"top.wushanghui.annotation"}, useDefaultFilters = false, includeFilters = {@ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})})
@ComponentScans(value = {
        @ComponentScan(value = {"top.wushanghui.annotation"}, useDefaultFilters = false, includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})}),
        @ComponentScan(value = {"top.wushanghui.annotation"}, useDefaultFilters = false, includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Service.class})})
}
)
@Configuration
@Import({Dog.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class ComponentRegistrationConfig {

    @Lazy
    @Bean(name = "person1")
    public Person getPerson() {
        System.out.println("给容器中添加Person....");
        return new Person("Jerry", 5);
    }


    @Bean("showCmd")
    @Conditional(WindowsCondition.class)
    public ShowCommand winCmd() {
        return new WindowsShowCommand();
    }

    @Bean("showCmd")
    @Conditional(LinuxCondition.class)
    public ShowCommand linuxCmd() {
        return new LinuxShowCommand();
    }

    @Bean
    public ColorFactoryBean colorFactoryBean() {
        return new ColorFactoryBean();
    }

}
