package top.wushanghui.entity;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author jue
 * @date 2020/8/15 22:44
 * @describe
 */
public class User {

    private BigInteger id;
    private String name;
    private String status;
    private BigDecimal money;

    public User(BigInteger id, String name, String status, BigDecimal money) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.money = money;
    }

    public User(String name, String status, BigDecimal money) {
        this.name = name;
        this.status = status;
        this.money = money;
    }

    public User() {
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", money=" + money +
                '}';
    }
}
