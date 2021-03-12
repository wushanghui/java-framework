package top.wushanghui.rabbitmq.confirm;

import com.rabbitmq.client.*;
import top.wushanghui.rabbitmq.utils.RabbitConstant;
import top.wushanghui.rabbitmq.utils.RabbitUtils;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class WeatherBureau {

    public static void main(String[] args) throws IOException, TimeoutException {
        Map<String, String> area = new LinkedHashMap<>();

        // 苏北
        area.put("china.jiangsu.xuzhou.20210311", "中国江苏<<徐州>>2021年3月11日天气数据");
        area.put("china.jiangsu.shuqian.20210311", "中国江苏<<宿迁>>2021年3月11日天气数据");
        area.put("china.jiangsu.lianyungang.20210311", "中国江苏<<连云港>>2021年3月11日天气数据");
        area.put("china.jiangsu.huaian.20210311", "中国江苏<<淮安>>2021年3月11日天气数据");
        area.put("china.jiangsu.yancheng.20210311", "中国江苏<<盐城>>2021年3月11日天气数据");

        // 上海·
        area.put("china.shanghai.songjiangqu.20210311", "中国上海<<松江区>>2021年3月11日天气数据");
        area.put("china.shanghai.jinganqu.20210312", "中国上海<<静安区>>2021年3月12日天气数据");
        area.put("china.shanghai.xuhuiqu.20210312", "中国上海<<徐汇区>>2021年3月12日天气数据");

        Connection connection = RabbitUtils.getConnection();
        Channel channel = connection.createChannel();
        //开启confirm监听模式
        channel.confirmSelect();
        channel.addConfirmListener(new ConfirmListener() {
            @Override
            public void handleAck(long deliveryTag, boolean multiple) throws IOException {
                //第二个参数代表接收的数据是否为批量接收，一般我们用不到。
                System.out.println("消息已被Broker 接收, deliveryTag: " + deliveryTag + ", multiple: " + multiple);
            }

            @Override
            public void handleNack(long deliveryTag, boolean multiple) throws IOException {
                System.out.println("消息已被Broker 拒收, deliveryTag: " + deliveryTag + ", multiple: " + multiple);
            }
        });
        channel.addReturnListener(new ReturnCallback() {
            @Override
            public void handle(Return r) {
                System.err.println("===========================");
                System.err.println("Return编码：" + r.getReplyCode() + ", Return描述:" + r.getReplyText());
                System.err.println("交换器:" + r.getExchange() + ", 路由key:" + r.getRoutingKey());
                System.err.println("Return主题：" + new String(r.getBody()));
                System.err.println("===========================");
            }
        });
        for (Map.Entry<String, String> me : area.entrySet()) {
            //Routing key 第二个参数相当于数据筛选的条件
            //第三个参数为：mandatory true代表如果消息无法正常投递则return回生产者，如果false，则直接将消息放弃。
            channel.basicPublish(RabbitConstant.EXCHANGE_WEATHER_TOPIC, me.getKey(), true, null, me.getValue().getBytes());
        }

        /*channel.close();
        connection.close();*/
    }
}
