package annotation.bean;

import annotation.Factory;

/**
 * @auther 齿轮
 * @create 2023-03-11-16:23
 */
@Factory(type = Person.class, id = "Student")
public class Student implements Person {
    @Override
    public String learn() {
        return "everyThing";
    }
}
