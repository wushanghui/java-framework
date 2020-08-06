package top.wushanghui.bean;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author wsh
 * @date 2020/8/6 11:29
 */
public class Student {

    //1 数组类型属性
    private String[] array;
    //2 list 集合类型属性
    private List<String> list;
    //3 map 集合类型属性
    private Map<String,String> maps;
    //4 set 集合类型属性
    private Set<String> sets;
    // 5 list 中设置对象
    private List<Course> courses;
    // 6 properties 注入
    private Properties properties;

    public void setArray(String[] array) {
        this.array = array;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public void setSets(Set<String> sets) {
        this.sets = sets;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "Student{" +
                "array=" + Arrays.toString(array) +
                ", list=" + list +
                ", maps=" + maps +
                ", sets=" + sets +
                ", courses=" + courses +
                ", properties=" + properties +
                '}';
    }
}
