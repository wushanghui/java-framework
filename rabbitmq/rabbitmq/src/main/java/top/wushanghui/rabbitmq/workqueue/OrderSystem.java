package top.wushanghui.rabbitmq.workqueue;

import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import top.wushanghui.rabbitmq.utils.RabbitConstant;
import top.wushanghui.rabbitmq.utils.RabbitUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class OrderSystem {

    public static void main(String[] args) throws IOException, TimeoutException {

        Connection connection = RabbitUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(RabbitConstant.QUEUE_SMS, false, false, false, null);
        for(int i = 100 ; i <= 10000 ; i++) {
            Message message = new Message("乘客" + i, "13900000" + i, "您的车票已预订成功");
            String messageJsonStr = new Gson().toJson(message);
            channel.basicPublish("" , RabbitConstant.QUEUE_SMS , null , messageJsonStr.getBytes());
        }
        System.out.println("发送数据成功");
        channel.close();
        connection.close();
    }
}
