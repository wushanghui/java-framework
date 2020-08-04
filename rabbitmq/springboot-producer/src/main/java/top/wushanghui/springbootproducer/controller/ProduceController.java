package top.wushanghui.springbootproducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wushanghui.springbootproducer.bean.Employee;
import top.wushanghui.springbootproducer.service.MessageProducerService;

/**
 * @author jue
 * @date 2020/7/21 21:28
 * @describe
 */
@RestController
public class ProduceController {

    @Autowired
    private MessageProducerService messageProducerService;

    @GetMapping("/test")
    public String produceMessage() {
        for (int i = 1; i <= 1; i++) {
            messageProducerService.sendMessage(new Employee(String.valueOf(i), "小明", 25));
        }
        return "投递成功";
    }
}
