package top.wushanghui.ioc;

import com.sun.scenario.effect.impl.prism.PrImage;

import java.util.Arrays;
import java.util.List;

/**
 * @author wsh
 * @date 2020/7/28 16:28
 */
public class User {

    private Integer id;
    private String name;
    private Integer age;

    private Dog dog;

    private String[] favorites;

    private List<Cat> cats;

    public User(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public String[] getFavorites() {
        return favorites;
    }

    public void setFavorites(String[] favorites) {
        this.favorites = favorites;
    }

    public List<Cat> getCats() {
        return cats;
    }

    public void setCats(List<Cat> cats) {
        this.cats = cats;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", dog=" + dog +
                ", favorites=" + Arrays.toString(favorites) +
                ", cats=" + cats +
                '}';
    }
}
