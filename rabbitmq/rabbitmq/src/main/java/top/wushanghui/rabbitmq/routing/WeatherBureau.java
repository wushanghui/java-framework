package top.wushanghui.rabbitmq.routing;

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
        // 苏北五虎
        area.put("china.jiangsu.xuzhou.20210311", "中国江苏<<徐州>>2021年3月11日天气数据");
        area.put("china.jiangsu.shuqian.20210311", "中国江苏<<宿迁>>2021年3月11日天气数据");
        area.put("china.jiangsu.lianyungang.20210311", "中国江苏<<连云港>>2021年3月11日天气数据");
        area.put("china.jiangsu.huaian.20210311", "中国江苏<<淮安>>2021年3月11日天气数据");
        area.put("china.jiangsu.yancheng.20210311", "中国江苏<<盐城>>2021年3月11日天气数据");

        // 苏中
        area.put("china.jiangsu.nanjing.20210311", "中国江苏<<南京>>2021年3月11日天气数据");
        area.put("china.jiangsu.yangzhou.20210311", "中国江苏<<扬州>>2021年3月11日天气数据");
        area.put("china.jiangsu.taizhou.20210311", "中国江苏<<泰州>>2021年3月11日天气数据");
        area.put("china.jiangsu.nantong.20210311", "中国江苏<<南通>>2021年3月11日天气数据");
        area.put("china.jiangsu.zhenjiang.20210311", "中国江苏<<镇江>>2021年3月11日天气数据");

        Connection connection = RabbitUtils.getConnection();
        Channel channel = connection.createChannel();
        Iterator<Map.Entry<String, String>> itr = area.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<String, String> me = itr.next();
            //Routing key 第二个参数相当于数据筛选的条件
            channel.basicPublish(RabbitConstant.EXCHANGE_WEATHER_ROUTING, me.getKey(), null, me.getValue().getBytes());
        }

        channel.close();
        connection.close();
    }
}
