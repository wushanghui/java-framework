package top.wushanghui.bean;

/**
 * @author wsh
 * @date 2020/8/6 11:35
 */
public class Course {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                '}';
    }
}
