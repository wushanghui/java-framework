package top.wushanghui.multi.bean.impl;

import org.springframework.stereotype.Component;
import top.wushanghui.multi.bean.MultiBean;

/**
 * @author jue
 * @date 2020/8/13 23:01
 * @describe
 */
@Component
public class MultiBeanImpl implements MultiBean {
    @Override
    public void testMulti() {
        System.out.println("测试多个切面！");
    }
}
