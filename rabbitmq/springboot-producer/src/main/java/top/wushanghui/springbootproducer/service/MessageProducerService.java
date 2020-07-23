package top.wushanghui.springbootproducer.service;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ReturnCallback;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
import org.springframework.stereotype.Service;
import top.wushanghui.springbootproducer.bean.Employee;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author jue
 * @date 2020/7/21 21:32
 * @describe
 */
@Service
public class MessageProducerService {

    private static Logger logger = LoggerFactory.getLogger(MessageProducerService.class);

    private static final String EXCHANGE = "springboot-exchange";
    private static final String ROUTING_KEY = "employee.obj";

    @Resource
    private RabbitTemplate rabbitTemplate;

    /**
     * CorrelationData 消息的附加信息，即自定义id
     * isack 代表消息是否被broker（MQ）接收 true 代表接收 false代表拒收。
     * cause 如果拒收cause则说明拒收的原因，帮助我们进行后续处理
     */
    private ConfirmCallback confirmCallback = (correlationData, ack, cause) -> {
        logger.info(correlationData.toString());
        if (ack) {
            logger.info("消息投递成功！");
        } else {
            logger.error("消息投递失败！，原因：{}", cause);
        }
    };

    private ReturnCallback returnCallback = (message, replyCode, replyText, exchange, routingKey) -> {
        logger.error("message: {}, ", message);
        logger.error("replyCode: {}, ", replyCode);
        logger.error("replyText: {}, ", replyText);
        logger.error("exchange: {}, ", exchange);
        logger.error("routingKey: {}, ", routingKey);
    };

    public void sendMessage(Employee emp) {
        //CorrelationData对象的作用是作为消息的附加信息传递，通常我们用它来保存消息的自定义id
        CorrelationData cd = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.setConfirmCallback(confirmCallback);
        rabbitTemplate.setReturnCallback(returnCallback);
        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, new Gson().toJson(emp), cd);
    }
}
