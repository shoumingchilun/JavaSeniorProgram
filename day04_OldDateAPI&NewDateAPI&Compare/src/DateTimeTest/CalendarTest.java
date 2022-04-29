package DateTimeTest;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * @auther 齿轮
 * @create 2022-03-07-22:44
 * <p>
 * 1.实例化
 * 方法一：创建子类（GregorianCalendar）的对象
 * 方法二：调用其静态方法getInstance()
 * <p>
 * 2.常用方法
 * get();
 * set();
 * add();
 * getTime();   Calendar->Date
 * setTime();    Date->Calendar
 */
public class CalendarTest {
    @Test
    public void testCalendar() {
        Calendar calendar = Calendar.getInstance();
        //get();
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
        //set();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        //add();
        calendar.add(Calendar.DAY_OF_MONTH, 3);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //getTime();
        Date date = calendar.getTime();
        System.out.println(date);

        //setTime();
        Date date1 = new Date();
        calendar.setTime(date1);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);


    }


}
