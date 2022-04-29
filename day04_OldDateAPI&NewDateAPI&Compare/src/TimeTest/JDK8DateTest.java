package TimeTest;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * @auther 齿轮
 * @create 2022-03-08-10:18
 *
 * 详情见下
 *
 */
public class JDK8DateTest {
    //旧：加偏移值
    @Test
    public void testDate(){
        Date date1 = new Date(2020-1900,4-1,1);
        System.out.println(date1);
    }
    //新
    @Test
    public void Test1(){
        //now():获取当前的日期、时间、日期加时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        //of():设置指定的年月日时分秒，无偏移量
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 1, 2, 1, 33, 33);
        System.out.println(localDateTime1);

        //getXxx():获取相关属性
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getHour());
        System.out.println(localDateTime.getMinute());
        System.out.println(localDateTime.getSecond());

        //不可变性
        LocalDate localDate1 = localDate.withDayOfMonth(15);
        System.out.println(localDate);
        System.out.println(localDate1);

        LocalDateTime localDateTime2 = localDateTime.plusMonths(3);
        System.out.println(localDateTime);
        System.out.println(localDateTime2);
        LocalDateTime localDateTime3 = localDateTime.minusMonths(3);
        System.out.println(localDateTime);
        System.out.println(localDateTime3);
    }

    //instant的使用
    @Test
    public void test2(){
        //now():获取本初子午线时间
        Instant instant = Instant.now();
        System.out.println(instant);//本初子午线
        //atOffset():添加时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);
        //toEpochMilli():获取1970年1月1日0点0分0秒(UTC)开始的毫秒数
        long milli = instant.toEpochMilli();
        System.out.println(milli);
        //ofEpochMilli():给定毫秒数获取Instant实例
        Instant instant1 = Instant.ofEpochMilli(2435234523256L);
        System.out.println(instant1);
    }

    //DateTimeFormatter:格式化或解析日期时间，类似SimpleDateFormat
    @Test
    public void test3(){
//预定义的标准格式
        //格式化
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        System.out.println(formatter.format(localDateTime));
        //解析
        TemporalAccessor parse = formatter.parse("2022-03-08T11:01:49.0736946");
        System.out.println(parse);
//本地化相关格式
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        //DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        //格式化
        System.out.println(formatter1.format(localDateTime));
        //System.out.println(formatter2.format(localDateTime));
        //解析
        //......
//自定义格式
        //格式化
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        System.out.println(formatter2.format(LocalDateTime.now()));
        //解析
        TemporalAccessor parse1 = formatter2.parse("2022-03-08 11:14:47");
        System.out.println(parse1);

    }
}
