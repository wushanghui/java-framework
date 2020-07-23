package top.wushanghui.rabbitmq.helloworld;

import com.rabbitmq.client.*;
import top.wushanghui.rabbitmq.utils.RabbitConstant;
import top.wushanghui.rabbitmq.utils.RabbitUtils;

import java.io.IOException;

public class Consumer {
    public static void main(String[] args) throws IOException {
        Connection conn = RabbitUtils.getConnection();
        //创建通道
        Channel channel = conn.createChannel();
        channel.queueDeclare(RabbitConstant.QUEUE_HELLOWORLD, false, false, false, null);
        //创建一个消息消费者
        //第二个参数代表是否自动确认收到消息，false代表手动编程来确认消息，这是MQ的推荐做法
        //第三个参数要传入DefaultConsumer的实现类
        channel.basicConsume(RabbitConstant.QUEUE_HELLOWORLD, false, new MyConsumer(channel));

    }
}

class MyConsumer extends DefaultConsumer {
    private Channel channel;

    //重写构造函数,Channel通道对象需要从外层传入，在handleDelivery中要用到
    public MyConsumer(Channel channel) {
        super(channel);
        this.channel = channel;
    }

    @Override
    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

        /*super.handleDelivery(consumerTag,envelope,properties,body);*/
        String messageBody = new String(body);
        System.out.println("消费者接收到：" + messageBody);
        //签收消息,确认消息
        //envelope.getDeliveryTag() 获取这个消息的TagId
        //false只确认签收当前的消息，设置为true的时候则代表签收该消费者所有未签收的消息
        channel.basicAck(envelope.getDeliveryTag(), false);
    }
}