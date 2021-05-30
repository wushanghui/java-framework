package top.wushanghui.annotation.condition;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import top.wushanghui.annotation.entity.Animal;

/**
 * @author jue
 * @date 2021/4/10 18:12
 * @describe
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {


    /**
     * AnnotationMetadata：当前类的注解信息
     * BeanDefinitionRegistry:BeanDefinition注册类；
     * 		把所有需要添加到容器中的bean；调用
     * 		BeanDefinitionRegistry.registerBeanDefinition手工注册进来
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        boolean definition1 = registry.containsBeanDefinition("top.wushanghui.annotation.entity.Cat");
        boolean definition2 = registry.containsBeanDefinition("top.wushanghui.annotation.entity.Dog");
        if(definition1 && definition2){
            //指定Bean定义信息；（Bean的类型，Bean。。。）
            RootBeanDefinition beanDefinition = new RootBeanDefinition(Animal.class);
            //注册一个Bean，指定bean名
            registry.registerBeanDefinition("animal", beanDefinition);
        }
    }
}
