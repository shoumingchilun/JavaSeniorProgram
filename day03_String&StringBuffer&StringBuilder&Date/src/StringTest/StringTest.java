package StringTest;

import org.junit.Test;

/**
 * @auther 齿轮
 * @create 2022-03-06-11:13
 * <p>
 * 详情见下
 */
public class StringTest {
    /*
     * String:用一对""引起来表示
     * 1、声明为final，不可被继承
     * 2、实现了Serializable接口：可序列化(可传输
     * 3、实现了Comparable接口：可比较大小
     * 4、String内部定义了final byte[] value 用于存储字符串数据
     * 5、String代表不可变的字符序列(不可变性
     *       对字符串重新赋值时，需重写指定内存区域赋值，不能使用原有的value进行赋值
     *       对现有字符串进行连接操作时，此时的字符串值声明在字符串常量池中
     *       调用String的replace()方法修改指定字符串时，也需要重新指定内存区域
     */
    @Test
    public void test1() {
        String str = "123";//字面量的定义方式
        String str2 = "123";//字面量的定义方式
        System.out.println(str == str2);//true

    }

    /*
     * String的实例化方式：
     * 1、字面量定义
     * 2、new+构造器
     *
     */
    @Test
    public void test2() {
        String s1 = "javaEE";
        String s2 = "javaEE";
        String s3 = new String("javaEE");
        String s4 = new String("javaEE");
        System.out.println(s1 == s2);//true
        System.out.println(s1 == s3);//false
        System.out.println(s1 == s4);//false
        System.out.println(s3 == s4);//false

        System.out.println("*****************************************************");
        Person p1 = new Person("Tom", 12);
        Person p2 = new Person("Tom", 12);
        System.out.println(p1.name.equals(p2.name));//true
        System.out.println(p1.name == p2.name);//true
    }

    /*
     * 1、常量与常量的拼接结果在常量池里，且常量池不会存相同的常量
     * 2、拼接时只要有一个变量，结果就在堆中
     * 3、拼接时调用intern()方法，结果在常量池中
     *
     * */
    @Test
    public void test3() {
        String s1 = "javaEE";
        String s2 = "hadoop";

        String s3 = "javaEEhadoop";
        String s4 = "javaEE" + "hadoop";
        String s5 = s1 + "hadoop";
        String s6 = "javaEE" + s2;
        String s7 = s1 + s2;
        String s8 = s7.intern();
        System.out.println(s3 == s4);//true
        System.out.println(s3 == s5);//false
        System.out.println(s3 == s6);//false
        System.out.println(s5 == s6);//false
        System.out.println(s3 == s7);//false
        System.out.println(s3 == s8);//true
    }
}
