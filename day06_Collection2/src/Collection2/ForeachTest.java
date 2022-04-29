package Collection2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @auther 齿轮
 * @create 2022-03-10-17:20
 * <p>
 * jdk5.0新增foreach循环
 */
public class ForeachTest {
    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("QIQI", 29));
        //for(集合元素的类型 局部变量 : 集合对象)
        for (Object obj : coll) {
            System.out.println(obj);
        }
    }

    @Test
    public void test2() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        for (int i : arr) {
            System.out.println(i);
        }
    }

    @Test
    public void test3() {
        String[] arr = new String[]{"MM", "MM", "MM"};
//        给arr赋值
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = "GG";
//        }
//     给s(局部变量)赋值
        for (String s : arr) {
            s = "GG";
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
