package annotation.bean;

import annotation.Factory;

/**
 * @auther 齿轮
 * @create 2023-03-11-16:24
 */
@Factory(type = Person.class, id = "Teacher")
public class Teacher implements Person{
    @Override
    public String learn() {
        return "How to teach.";
    }
}
