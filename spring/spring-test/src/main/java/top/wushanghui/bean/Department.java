package top.wushanghui.bean;

/**
 * @author wsh
 * @date 2020/8/6 9:22
 */
public class Department {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                '}';
    }
}
