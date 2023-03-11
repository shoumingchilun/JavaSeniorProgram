package annotation;

import annotation.bean.Person;
import annotation.bean.Student;
import annotation.bean.Teacher;
import annotation.bean.Worker;

/**
 * @auther 齿轮
 * @create 2023-03-11-16:26
 */
public class PersonFactory {
    public Person birth(String type) throws Exception {
        if (type.equals("S")){
            return new Student();
        }else if (type.equals("T")){
            return new Teacher();
        }else if (type.equals("W")){
            return new Worker();
        }else {
            throw new Exception("Not Found the index :"+type);
        }
    }

//    public static void main(String[] args) throws Exception {
//        PersonFactory factory = new PersonFactory();
//        Person s = factory.birth("S");
//        System.out.println(s);
//    }
}
