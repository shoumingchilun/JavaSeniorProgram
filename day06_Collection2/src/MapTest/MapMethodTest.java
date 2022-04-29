package MapTest;

import org.junit.Test;

import java.util.*;

/**
 * @auther 齿轮
 * @create 2022-03-14-21:43
 * <p>
 * Map中定义的方法：
 * 添加、删除、修改操作：
 * Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
 * void putAll(Map m):将m中的所有key-value对存放到当前map中
 * Object remove(Object key)：移除指定key的key-value对，并返回value
 * void clear()：清空当前map中的所有数据
 * 元素查询的操作：
 * Object get(Object key)：获取指定key对应的value
 * boolean containsKey(Object key)：是否包含指定的key
 * boolean containsValue(Object value)：是否包含指定的value
 * int size()：返回map中key-value对的个数
 * boolean isEmpty()：判断当前map是否为空
 * boolean equals(Object obj)：判断当前map和参数对象obj是否相等
 * 元视图操作的方法：
 * Set keySet()：返回所有key构成的Set集合
 * Collection values()：返回所有value构成的Collection集合
 * Set entrySet()：返回所有key-value对构成的Set集合
 * <p>
 * *总结：常用方法：
 * * 添加：put(Object key,Object value)
 * * 删除：remove(Object key)
 * * 修改：put(Object key,Object value)
 * * 查询：get(Object key)
 * * 长度：size()
 * * 遍历：keySet() / values() / entrySet()
 */
public class MapMethodTest {
    @Test
    public void test1() {
        Map map = new HashMap();
        //添加
        map.put("AA", 123);
        map.put(45, 124);
        map.put("BB", 13);
        //修改
        map.put("AA", 87);
        System.out.println(map);
        Map map1 = new HashMap();
        map1.put("CC",43);
        map1.put("DD",34);
        //添加全部
        map.putAll(map1);
        System.out.println(map);
        //删除
        System.out.println(map.remove(45));
        System.out.println(map);
        //清空
        System.out.println(map1.size());
        map1.clear();
        System.out.println(map1.size());
    }

    @Test
    public void test2(){
        HashMap map = new HashMap();
        map.put("AA", 123);
        map.put(45, 124);
        map.put("BB", 13);
        //获取
        System.out.println(map.get(45));
        //是否存在
        System.out.println(map.containsKey("AA"));
        System.out.println(map.containsValue(13));
        //是否为空
        map.clear();
        System.out.println(map.isEmpty());
    }

    @Test
    public void test3(){
        HashMap map = new HashMap();
        map.put("AA", 123);
        map.put(45, 124);
        map.put("BB", 13);
        //遍历key集
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //遍历values集
        Collection values = map.values();
        for(Object obj:values){
            System.out.println(obj);
        }
        //遍历key-value集
        Set set1 = map.entrySet();
        Iterator iterator1 = set1.iterator();
        while(iterator1.hasNext()){
            Map.Entry entry = (Map.Entry) iterator1.next();
            System.out.println(entry.getKey()+"="+entry.getValue());
//            System.out.println(entry);
        }
    }

}
