package top.wushanghui.springbootconsumer;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class MessageConsumer {

    private static Logger logger = LoggerFactory.getLogger(MessageConsumer.class);
    //@RabbitListener注解用于声明式定义消息接受的队列与exhcange绑定的信息
    //在SpringBoot中，消费者这端使用注解获取消息
    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(value = "springboot-queue", durable = "true"),
                    exchange = @Exchange(value = "springboot-exchange", type = "topic"),
                    key = "#"
            )
    )
    //用于接收消息的方法
    @RabbitHandler //通知SpringBoot下面的方法用于接收消息。
    // 这个方法运行后将处于等待的状态，有新的消息进来就会自动触发下面的方法处理消息
    //@Payload 代表运行时将消息反序列化后注入到后面的参数中
    public void handleMessage(String message, Channel channel,
                              @Headers Map<String, Object> headers) {
        logger.info("=========================================");
        logger.info("接收到" + message);
        //所有消息处理后必须进行消息的ack，channel.basicAck()
        Long tag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        logger.info(tag.toString());
        try {
            channel.basicAck(tag, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("=========================================");
    }
}
