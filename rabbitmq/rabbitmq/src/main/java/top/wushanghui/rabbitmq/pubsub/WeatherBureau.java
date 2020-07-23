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
        String input = new Scanner(System.in).next();
        Channel channel = connection.createChannel();
        channel.basicPublish(RabbitConstant.EXCHANGE_WEATHER, "", null, input.getBytes());
        channel.close();
        connection.close();
    }
}
