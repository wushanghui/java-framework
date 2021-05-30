package top.wushanghui.rabbitmq.pubsub;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import top.wushanghui.rabbitmq.utils.RabbitConstant;
import top.wushanghui.rabbitmq.utils.RabbitUtils;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

public class WeatherBureau {

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitUtils.getConnection();
        String message = "上海明天天气，晴转多云！";
        Channel channel = connection.createChannel();
        channel.basicPublish(RabbitConstant.EXCHANGE_WEATHER, "", null, message.getBytes());
        channel.close();
        connection.close();
        System.out.println("天气发布成功");
    }
}
