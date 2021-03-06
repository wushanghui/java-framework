package top.wushanghui.exchange;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDateTime;
import java.util.Date;

public class NewsProducer {

    private RabbitTemplate rabbitTemplate = null;

    public RabbitTemplate getRabbitTemplate() {
        return rabbitTemplate;
    }

    public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendNews(String routingKey, News news) {
        //convertAndSend 用于向exchange发送数据
        //第一个参数是routingkey
        //第二个参数是要传递的对象，可以是字符串、byte【】或者任何实现了【序列化接口】的对象
        rabbitTemplate.convertAndSend(routingKey, news);
        System.out.println("新闻发送成功");
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:application.xml");
        NewsProducer np = (NewsProducer) ctx.getBean("newsProducer");
        np.sendNews("us.20210316", new News("推特", "拜登当美国总统了", new Date(), "国外新闻"));
        np.sendNews("china.20210316", new News("抖音", "54万的R8有吗", new Date(), "国内新闻"));
    }
}
