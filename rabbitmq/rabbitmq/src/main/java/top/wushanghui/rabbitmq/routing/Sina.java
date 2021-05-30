package top.wushanghui.rabbitmq.routing;

import com.rabbitmq.client.*;
import top.wushanghui.rabbitmq.utils.RabbitConstant;
import top.wushanghui.rabbitmq.utils.RabbitUtils;

import java.io.IOException;

public class Sina {

    public static void main(String[] args) throws IOException {
        Connection connection = RabbitUtils.getConnection();
        final Channel channel = connection.createChannel();
        channel.queueDeclare(RabbitConstant.QUEUE_SINA, false, false, false, null);

        channel.queueBind(RabbitConstant.QUEUE_SINA, RabbitConstant.EXCHANGE_WEATHER_ROUTING, "china.jiangsu.nanjing.20210311");
        channel.queueBind(RabbitConstant.QUEUE_SINA, RabbitConstant.EXCHANGE_WEATHER_ROUTING, "china.jiangsu.yangzhou.20210311");
        channel.queueBind(RabbitConstant.QUEUE_SINA, RabbitConstant.EXCHANGE_WEATHER_ROUTING, "china.jiangsu.taizhou.20210311");
        channel.queueBind(RabbitConstant.QUEUE_SINA, RabbitConstant.EXCHANGE_WEATHER_ROUTING, "china.jiangsu.nantong.20210311");
        channel.queueBind(RabbitConstant.QUEUE_SINA, RabbitConstant.EXCHANGE_WEATHER_ROUTING, "china.jiangsu.zhenjiang.20210311");

        channel.basicQos(1);
        channel.basicConsume(RabbitConstant.QUEUE_SINA , false , new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("新浪收到气象信息：" + new String(body));
                channel.basicAck(envelope.getDeliveryTag() , false);
            }
        });
    }
}
