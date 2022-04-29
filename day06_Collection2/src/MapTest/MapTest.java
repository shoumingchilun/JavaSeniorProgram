package MapTest;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther 齿轮
 * @create 2022-03-13-14:57
 * 一、Map：双列数据，存储key-value对的数据
 * --------HashMap：作为Map主要实现类；线程不安全，效率高；存储null的key和value；（底层：jdk7：数组+链表；jdk8：数组+链表+红黑树）
 * ---------------LinkedHashMap： 保证遍历Map元素时，可以按添加的顺序实现遍历（原有HashMap底层结构添加了一对指针）；平凡遍历效率高于HashMap
 * --------TreeMap：保证按添加的顺序进行排序 ，实现排序遍历（key的自然排序和定制排序）；底层使用红黑树
 * --------Hashtable：Map古老实现类；线程安全，效率低；不能存储null的key和value
 * ---------------Properties：常用来处理配置文件，key和value都是String类型
 *
 * 二、Map结构
 * key：无序，不可重复，使用Set存储所有的key----->key的类需要重写equals()和hashCode()
 * value：无序，可重复，使用Collection存储所有的value----->value的类要重写equals()
 * 一个键值对：key-value组成一个Entry对象
 * Entry：无序，不可重复，使用Set存储所有的Entry
 *
 */
public class MapTest {
    @Test
    public void test1() {
        Map map = new HashMap();
//        map = new Hashtable();
        map.put(null, 123);
    }
}
