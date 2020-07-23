package top.wushanghui.springbootproducer.bean;

import java.io.Serializable;

/**
 * @author jue
 * @date 2020/7/21 21:33
 * @describe
 */
public class Employee implements Serializable {
    private String empno;
    private String name;
    private Integer age;

    public Employee(String empno, String name, Integer age) {
        this.empno = empno;
        this.name = name;
        this.age = age;
    }

    public String getEmpno() {
        return empno;
    }

    public void setEmpno(String empno) {
        this.empno = empno;
    }

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
}
