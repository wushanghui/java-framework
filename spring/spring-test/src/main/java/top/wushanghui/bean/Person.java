package top.wushanghui.bean;

/**
 * @author wsh
 * @date 2020/8/6 14:37
 */
public class Person {

    private Dog dog;

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "dog=" + dog +
                '}';
    }
}
