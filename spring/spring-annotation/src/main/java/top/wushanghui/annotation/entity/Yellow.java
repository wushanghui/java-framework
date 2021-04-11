package top.wushanghui.annotation.entity;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author jue
 * @date 2021/4/10 23:05
 * @describe
 */
@Component
public class Yellow {


    public Yellow() {
        System.out.println("yellow constructor...");
    }

    //对象创建并赋值之后调用
    @PostConstruct
    public void init() {
        System.out.println("yellow....@PostConstruct...");
    }

    //容器移除对象之前
    @PreDestroy
    public void detory() {
        System.out.println("yellow....@PreDestroy...");
    }
}
