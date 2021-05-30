package top.wushanghui.rabbitmq.topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
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
        Iterator<Map.Entry<String, String>> itr = area.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<String, String> me = itr.next();
            //Routing key 第二个参数相当于数据筛选的条件
            channel.basicPublish(RabbitConstant.EXCHANGE_WEATHER_TOPIC,me.getKey() , null , me.getValue().getBytes());
        }

        channel.close();
        connection.close();
        System.out.println("天气数据发布成功");
    }
}
