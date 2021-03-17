package top.wushanghui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class NewsConsumer {

    public void rece(News news) {
        System.out.println("------");
        System.out.println("接收到最新新闻：" + news.getTitle() + ":" + news.getSource());
    }

    public void receive(String message) {
        System.out.println("接收到最新新闻：" + message);
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:application.xml");
    }
}
