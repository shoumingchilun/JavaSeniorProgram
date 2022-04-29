package DateTimeTest;

import org.junit.Test;

import java.util.Date;

/**
 * @auther 齿轮
 * @create 2022-03-06-23:38
 * <p>
 * 日期与时间API测试：
 * 1、System类中的currentTimeMillis()方法：返回当前时间与1970年1月1日0点0分0秒的时间差
 * 2、Date类：（java.util.Date||!java.sql.Date）
 * 两个构造器的使用：
 * Date():创建一个对应当前时间的Date对象
 * Date(long):创建指定毫秒数的Date对象
 * 两个方法的使用：
 * toString():显示当前的年、月、日、时、分、秒
 * getTime():获取当前对象Date对象对应的时间戳
 * 3、java.sql.Date对应数据库的日期类型的变量
 * 创建对象：java.sql.Date(long);
 * 实例化：util.Date->sql.Date：java.sql.Date(java.util.Date.getTime())
 */
public class DateTimeTest {
    @Test
    public void test1() {
        long time = System.currentTimeMillis();
        System.out.println(time);
    }

    @Test
    public void test2() {
        Date date1 = new Date();
        System.out.println(date1.toString());
        System.out.println(date1.getTime());//等价于System.currentTimeMillis()

        Date date2 = new Date(164658172651L);
        System.out.println(date2.toString());

        java.sql.Date date3 = new java.sql.Date(164658172651L);
        System.out.println(date3);
        //一：
//        Date date4 = new java.sql.Date(164658172651L);
//        java.sql.Date date5 = (java.sql.Date) date4;
        //二：
        Date date6 = new Date();
        java.sql.Date date7 = new java.sql.Date(date6.getTime());
    }
}
