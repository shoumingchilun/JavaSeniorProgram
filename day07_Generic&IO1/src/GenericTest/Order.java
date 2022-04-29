package GenericTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther 齿轮
 * @create 2022-03-16-12:30
 * <p>
 * 自定义泛型类
 * <p>
 * 异常类不能声明为泛型
 */
public class Order<T> {
    String orderName;
    int orderId;
    //类内部使用类的泛型
    T orderT;

    public Order() {
        //编译不通过
//        T[] arr = new T[10];
        T[] arr = (T[]) new Object[10];

    }

    public Order(String orderName, int orderId, T orderT) {
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    //如下三个方法都不是泛型方法
    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", orderT=" + orderT +
                '}';
    }

    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }
    //静态方法不能包含泛型
//    public static void show(T t){
//
//    }

    //泛型方法：方法中出现了泛型结构，泛型方法与数的泛型参数无关
    //方法是否为泛型与类的泛型无关
    public <E> List<E> copyFromArrayToList(E[] arr) {
        ArrayList<E> list = new ArrayList<>();
        for (E e : arr) {
            list.add(e);
        }
        return list;
    }
}
