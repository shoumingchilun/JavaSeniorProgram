package GenericTest;

import org.junit.Test;

import java.util.*;

/**
 * @auther 齿轮
 * @create 2022-03-16-10:58
 * <p>
 * 泛型的使用：
 * 1、jdk5新特性
 * 2、集合中使用泛型：
 * 总结：
 * （1集合接口或集合类在jdk5时都修改为带泛型的结构
 * （2实例化集合类时可指明具体的泛型类
 * （3指明完成后，凡是定义类或接口时，内部结构使用到类的泛型的位置，都指定为实例化的泛型类型
 * （4注意点：泛型类型必须为类，不是能是基本数据类型，需使用包装类
 * （5如果实例化时没有指明泛型的类型，默认为Object类
 * 3、如何自定义泛型类：泛型类、泛型接口、泛型方法
 */
public class GenericTest {
    //集合中使用泛型之前
    @Test
    public void test1() {
        //需求：存放数值
        ArrayList arrayList = new ArrayList();
        arrayList.add(78);
        arrayList.add(76);
        arrayList.add(13);
        arrayList.add(56);
        //问题一：类型不安全
//        arrayList.add("3w");
        for (Object data : arrayList) {
            //问题二：强转可能出现类型转换异常（ClassCastException）
            int temp = (int) data;
            System.out.println(temp);
        }
    }

    //集合中使用泛型之后
    @Test
    public void test2() {
        //泛型为类型，不能是基本数据类型
        ArrayList<Integer> list = new ArrayList<>();
        list.add(78);
        list.add(54);
        list.add(23);
        list.add(342);
        //编译时会进行类型检查，保证数据安全
//        list.add("3weq");
        for (Integer data : list) {
            //避免了强转操作
            int temp = data;
            System.out.println(temp);
        }
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    //集合中使用泛型：Hashmap
    @Test
    public void test3() {
        Map<String, Integer> map = new HashMap<>();
        map.put("12", 123);
        map.put("14", 126);
        map.put("15", 143);
        map.put("13", 123);
        map.put("17", 133);
        Set<Map.Entry<String, Integer>> entry = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entry.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> next = iterator.next();
        }

    }

}
