package top.wushanghui.annotation.entity;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author jue
 * @date 2021/4/10 22:41
 * @describe
 */
@Component
public class Blue implements InitializingBean, DisposableBean {

    public Blue() {
        System.out.println("blue constructor...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("blue destroy...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("blue afterPropertiesSet...");
    }
}
