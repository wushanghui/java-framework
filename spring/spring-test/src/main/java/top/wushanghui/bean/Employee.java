package top.wushanghui.bean;

/**
 * @author wsh
 * @date 2020/8/6 9:22
 */
public class Employee {

    private Integer id;
    private String name;
    private Department department;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department=" + department +
                '}';
    }
}
