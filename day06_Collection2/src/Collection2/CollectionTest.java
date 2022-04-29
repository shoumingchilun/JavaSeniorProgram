package Collection2;

import org.junit.Test;

import java.util.*;

/**
 * @auther 齿轮
 * @create 2022-03-10-14:57
 */
public class CollectionTest {
    @Test
    public void test1() {
        //contains(Object):判断当前对象是否在集合中
        //判断时调用equals()方法
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("QIQI", 29));
        System.out.println(coll.contains(123));
        System.out.println(coll.contains(new String("Tom")));
        System.out.println(coll.contains(new Person("QIQI", 29)));

        //containsAll(Collection coll1):判断coll1的所有元素是不是在coll中
        Collection coll1 = Arrays.asList(123, 345);
        System.out.println(coll.containsAll(coll1));
    }

    @Test
    public void test2() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("QIQI", 29));

        //remove(Object):从当前集合中删除obj元素
        System.out.println(coll.remove(123));
        System.out.println(coll);

        //removeAll(Collection coll1):移除coll中coll1包含的所有元素(求差集)
        Collection coll1 = Arrays.asList(123, 456);
        coll.removeAll(coll1);
        System.out.println(coll);
    }

    @Test
    public void test3() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("QIQI", 29));

        //retainAll(Collection coll1):获取当前集合和coll1集合的交集
        Collection coll1 = Arrays.asList(123, 456);
        coll.retainAll(coll1);
        System.out.println(coll);

        //equals(Object obj):判断当前集合和形参集合是否相等
        System.out.println(coll1.equals(Arrays.asList(123, 456)));
    }

    @Test
    public void test4() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("QIQI", 29));

        //hashCode():返回当前对象哈希值
        System.out.println(coll.hashCode());

        //toArray():集合->数组
        Object[] objects = coll.toArray();
        for (Object object : objects) {
            System.out.println(object);
        }

        //数组->集合：Arrays.asList(T.....)
        List<String> list =Arrays.asList(new String[]{"1","a","A"});
        System.out.println(list);

        //iterator():返回Iterator接口实例，用于遍历集合元素
    }

}

class Person {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(name, age);
//    }
}
