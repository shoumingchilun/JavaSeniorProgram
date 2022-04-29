package GenericTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther 齿轮
 * @create 2022-03-16-12:35
 * <p>
 * 如何自定义泛型类：泛型类、泛型接口、泛型方法
 * <p>
 * 1、自定义泛型类、泛型接口
 */
public class GenericTest1 {
    @Test
    public void test1() {
        //不指明泛型类则默认为Object
        //建议：带泛型的类实例化时都指明类的泛型
        Order order = new Order();
        order.setOrderT(123);
        order.setOrderT("ABC");

        Order<String> order1 = new Order<>("orderAA", 1001, "order:AA");
        order1.setOrderT("AA:Hello");
    }

    @Test
    public void test2() {
        SubOrder order = new SubOrder();
        //子类继承带泛型的父类时，指明了泛型类型时，则实例化子类时不用再指明泛型
        order.setOrderT(123);

        SubOrder1<String> order1 = new SubOrder1<String>();
        order1.setOrderT("123");

    }

    @Test
    public void test3() {
        //泛型不同的引用不能相互赋值
        ArrayList<String> list1 = null;
        ArrayList<Integer> list2 = null;
//        list1 = list2;

    }

    @Test
    public void test4() {
        Order<String> order = new Order<String>();
        Integer[] arr = new Integer[]{1, 2, 3, 4};
        //泛型方法在调用时，指明泛型参数的类型
        List<Integer> list = order.copyFromArrayToList(arr);
        System.out.println(list);
    }
}
