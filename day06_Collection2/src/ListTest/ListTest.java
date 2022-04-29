package ListTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @auther 齿轮
 * @create 2022-03-10-17:31
 * <p>
 * Collection接口：单列集合，用来存储一个一个的数据
 * List接口：存储有序、可重复的数据。（动态数组）
 * ArrayList：List的主要实现类，线程不安全，效率高；底层使用Object[]存储
 * LinkedList：对于频繁插入、删除操作，使用效率比ArrayList高；底层使用双向链表存储
 * Vector：List的古老实现类，线程安全，效率低；底层使用Object[]存储
 * <p>
 * 三者异同：
 * 同：都实现了List接口，存储数据的特点相同：有序，可重复
 * 异：......
 * <p>
 * <p>
 * List常用方法
 * void add(int index, Object ele):在index位置插入ele元素
 * boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
 * Object get(int index):获取指定index位置的元素
 * int indexOf(Object obj):返回obj在集合中首次出现的位置
 * int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
 * Object remove(int index):移除指定index位置的元素，并返回此元素
 * Object set(int index, Object ele):设置指定index位置的元素为ele
 * List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合
 *
 * 总结：常用方法
 * 增：add(Object obj)
 * 删：remove(int index) / remove(Object obj)
 * 改：set(int index, Object ele)
 * 查：get(int index)
 * 插：add(int index, Object ele)
 * 长度：size()
 * 遍历：① Iterator迭代器方式
 *            ② 增强for循环
 *            ③ 普通的循环
 *
 */
public class ListTest {
    @Test
    public void test1() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add(new String("Tom"));
        list.add(false);
        list.add(new Date());
        System.out.println(list);
        //add()
        list.add(1, "BB");
        System.out.println(list);
        //addAll()
        List list1 = Arrays.asList(1, 2, 3);
        list.addAll(1, list1);
        System.out.println(list);
        //get()
        System.out.println(list.get(5));
    }

    @Test
    public void test2() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add(new String("Tom"));
        list.add(false);
        list.add(new Date());
        list.add(456);
        //indexOf()
        System.out.println(list.indexOf(false));
        //lastIndexOf()
        System.out.println(list.lastIndexOf(456));
        //remove()
        System.out.println(list.remove(3));
        System.out.println(list);
        //set()
        list.set(1, "CC");
        System.out.println(list);
        //subList
        System.out.println(list.subList(0, 2));
    }
}
