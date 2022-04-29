package Collection1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * @auther 齿轮
 * @create 2022-03-10-12:27
 * <p>
 * 一、概述
 * 1.集合、数组都是对多个数据进行存储操作的结构，简称java容器
 * （内存层面的存储，不是持久化的存储）
 * 2.1 数组存储的特点：（1初始化后长度确定；（2定义完成后元素类型确定
 * 2.2 数组存储的缺点：（1长度确定后无法修改；（2数组中提供方法有限，各类操作不便，效率不高；
 *                                      （3获取实际元素个数不易；（4储存特点：有序、可重复，无法满足对于无序、不可重复的需求
 *
 *二、集合框架
 *  Collection接口：单列集合，用来存储一个一个的数据
 *          List接口：存储有序、可重复的数据。（动态数组）
 *                  ArrayList、LinkedList、Vector
 *          Set接口：存储无序、不可重复的数据。（数学集合：无序性、互异性）
 *                  HashSet、LinkedHashSet、TreeSet
 * Map接口：双列集合，用来存储一对一对（key-value）的数据（数学函数 y = f(x)）
 *                  HashMap、LinkedHashMap、TreeMap、Hashtable、Properties
 *
 * 三、Collection接口的API（Abstract Methods）
 *
 *
 * 后续见day06
 *
 */
public class CollectionTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList();
        //add(Object obj):将元素obj添加到集合
        coll.add("AA");
        coll.add(123);
        coll.add("BB");
        coll.add(new Date());

        //size():返回添加的元素的个数
        System.out.println(coll.size());

        //addAll(Collection coll1):将coll1中的元素加入到coll中
        Collection coll1 = new ArrayList();
        coll1.add(456);
        coll1.add("CC");
        coll.addAll(coll1);
        System.out.println(coll.size());
        System.out.println(coll);

        //clear():清空集合元素
        coll.clear();

        //isEmpty():判断当前集合是否为空
        System.out.println(coll.isEmpty());
    }
}
