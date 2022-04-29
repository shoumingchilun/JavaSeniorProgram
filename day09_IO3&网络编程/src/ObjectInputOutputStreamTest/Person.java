package ObjectInputOutputStreamTest;

import java.io.Serializable;

/**
 * @auther 齿轮
 * @create 2022-03-18-17:17
 */
public class Person implements Serializable {//标识接口
    public static final long serialVersionUID = 2453423455653464565l;
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
