package DateTimeTest;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @auther 齿轮
 * @create 2022-03-07-20:36
 * 1、System类中的currentTimeMillis()方法：返回当前时间与1970年1月1日0点0分0秒的时间差
 * 2、Date类：（java.util.Date||java.sql.Date）
 * 3、SimpleDateFormat
 * 4、Calendar
 */
public class DateTimeTest {
    /*
    * SimpleDateFormat的使用:SimpleDateFormat对Date类的格式化和解析
    *
    * 1、格式化和解析
    * 格式化：日期->字符串   format(Date)
    * 解析：字符串->日期       parse(String)
    * (格式通过构造器形参实现)
    * 2、SimpleDateFormat的实例化
    *
    * */
    @Test
    public void testSimpleDateFormat() throws ParseException {
        //实例化(默认)
        SimpleDateFormat s1 = new SimpleDateFormat();

        //格式化
        Date date = new Date();
        System.out.println(date);

        String format = s1.format(date);
        System.out.println(format);

        //解析
        String str = "2022/3/7 下午8:46";
        Date d1 = s1.parse(str);
        System.out.println(d1);

        //实例化(指定格式化方法)
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        String format1 = sdf1.format(date);
        System.out.println(format1);

        Date d2 = sdf1.parse("2022-03-07 08:50:54");
        System.out.println(d2);
    }

}
