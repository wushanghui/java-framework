package top.wushanghui.annotation.entity;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author jue
 * @date 2021/4/11 13:06
 * @describe
 */
public class Employee {

    @Value("Tom")
    private String name;
    @Value("#{20+5}")
    private Integer age;
    @Value("${emp.job}")
    private String job;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                '}';
    }
}
