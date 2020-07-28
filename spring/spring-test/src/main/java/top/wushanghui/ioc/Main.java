package top.wushanghui.ioc;


import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author wsh
 * @date 2020/7/28 16:12
 */
public class Main {

    @Test
    public void testLoadBean1() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Book book = (Book) context.getBean("book");
        System.out.println(book); // top.wushanghui.ioc.Book@50b494a6
    }

    @Test
    public void testLoadBean2() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 根据class获取bean
        Book book = (Book) context.getBean(Book.class);
        System.out.println(book); // top.wushanghui.ioc.Book@cd2dae5

        /*
         * 如果spring配置文件中有两个相同Class，但是id或name不同
         * 可以使用id或name获取bean，但不能使用Class获取bean，会报错：
         * org.springframework.beans.factory.NoUniqueBeanDefinitionException:
         * No qualifying bean of type 'top.wushanghui.ioc.Book' available: expected single matching bean but found 2: book,book2
         * */
    }

    @Test
    public void testLoadBean3() {
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("D:\\ideacode\\java-framework\\spring\\spring-test\\src\\main\\resources\\applicationContext.xml");
        Book book = (Book) context.getBean("book");
        System.out.println(book); // top.wushanghui.ioc.Book@50b494a6
    }

    @Test
    public void testLoadBean4() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User) context.getBean("user");
        System.out.println(user); // User{id=1, name='小明', age=25}

        User user2 = (User) context.getBean("user2");
        System.out.println(user2); // User{id=2, name='小红', age=26}

        User user3 = (User) context.getBean("user3");
        System.out.println(user3); // User{id=3, name='小天', age=27}

        User user5 = (User) context.getBean("user5");
        System.out.println(user5); // User{id=null, name='null', age=null, dog=Dog{name='哈士奇', color='灰色'}}

        User user6 = (User) context.getBean("user6");
        System.out.println(user6); // User{id=null, name='null', age=null, dog=null, favorites=[乒乓球, 篮球, 网球]}
    }

}
