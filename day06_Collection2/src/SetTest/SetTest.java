package SetTest;

import org.junit.Test;

import java.util.*;

/**
 * @auther 齿轮
 * @create 2022-03-13-10:12
 * <p>
 * Collection接口：单列集合，用来存储一个一个的数据
 * Set接口：存储无序、不可重复的数据。（数学集合：无序性、互异性）
 * --------HashSet：主要实现类；线程不安全；可存储null
 * ----------------LinkedHashSet：作为HashSet子类；遍历内部数据时可以按添加顺序遍历
 * --------TreeSet：可以按照添加对象的指定属性进行排序
 * <p>
 * 1、Set接口没有额外的方法
 * 2、要求1：向Set中添加的数据，类要重写hashCode()和equals()
 * 要求2：重写的hashCode()和equals()尽可能保持一致性：相同对象必须要有相同散列值
 */
public class SetTest {
    /*
     * 一、Set:存储无序、不可重复的数据
     *         1、无序性：非随机性；存储数据按数据的哈希值添加
     *
     *         2、不可重复性：保证添加的元素按equals()判断时，不能返回true（添加的元素不能重复）
     *
     * 二、添加元素的过程：以HashSet为例：
     *         向HashSet中添加元素a，首先调用元素a所在类的hashCode()方法，计算a的哈希值，
     *         判断数组此位置是否有其他元素：
     *               如果没有，则添加成功；--->放入指定索引
     *               如果有，则比较a与其他元素的hash值：
     *                       如果不同，则添加成功；--->在指定索引上以链表方式存储
     *                       如果相同，则调用equals()方法：
     *                               返回false，添加成功；--->在指定索引上以链表方式存储
     *                               返回true，添加失败。
     *
     *
     * */
    @Test
    public void test1() {
        Set set = new HashSet();
        set.add(456);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new Date());
        set.add(129);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /*
    LinkedHashSet的使用
        LinkedHash作为HashSet的子类，在添加顺序的同时，每个数据还维护了两个引用，
        记录了前一个和后一个数据，频繁遍历效率高于HashSet。
    * */
    @Test
    public void test2() {
        Set set = new LinkedHashSet();
        set.add(456);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new Date());
        set.add(129);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
