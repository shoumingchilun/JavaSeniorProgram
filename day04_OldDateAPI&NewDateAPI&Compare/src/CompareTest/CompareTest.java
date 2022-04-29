package CompareTest;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @auther 齿轮
 * @create 2022-03-08-19:11
 *
 *如果需要排序，就需要比较对象大小
 * Comparable和Comparator
 *
 * 一、Comparable接口使用
 * 自然排序
 *重写compareTo()方法
 * 二、Comparator接口使用
 * 定制排序
 * 重写compare()方法
 *
 */
public class CompareTest {
    /*
    * Comparable接口使用举例
    * String重写了compareTo()方法
    * 重写Compare()的规则：
    * >,return 1;<,return -1;==,return 0
    * */
    @Test
    public void test1(){
        String[] arr = new String[]{"AA","CC","KK","MM","GG","JJ","DD"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void test2(){
        Goods[] arr =new Goods[4];
        arr[0] = new Goods("liangxiang",34);
        arr[1] = new Goods("dell",34);
        arr[2] = new Goods("xiaomi",12);
        arr[3] = new Goods("huawei",50);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void test3(){
        String[] arr = new String[]{"AA","CC","KK","MM","GG","JJ","DD"};
        Arrays.sort(arr, new Comparator() {
            public int compare(Object o1, Object o2) {
                if(o1 instanceof String&&o2 instanceof String){
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return -s1.compareTo(s2);
                }
                throw new RuntimeException("输入类型错误");
            }
        });
        System.out.println(Arrays.toString(arr));
    }

}
