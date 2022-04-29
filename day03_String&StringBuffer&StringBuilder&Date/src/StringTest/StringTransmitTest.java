package StringTest;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @auther 齿轮
 * @create 2022-03-06-16:29
 * <p>
 * String与基本数据类型、包装类之间的转换
 * String->基本数据类型、包装类：调用包装类的静态方法：parseXxx(str)
 * 基本数据类型、包装类->String：调用String类重载的valueOf(xxx)、""+xxx
 * <p>
 * String与char[]之间的转换
 * String->char[]：调用String的toCharArray()方法
 * char[]->String：调用String的构造器
 * <p>
 * String与byte[]之间的转换
 * String->byte[]：调用String的getBytes();编码
 * byte[]->String：调用String的构造器;解码
 * 解码与编码的字符集必须一致
 */
public class StringTransmitTest {

    @Test
    public void test1() {
        int num = Integer.parseInt("123");
        String str1 = "" + num;
        System.out.println(str1);
    }

    @Test
    public void test2() {
        String str1 = "abc123";
        char[] chars = str1.toCharArray();
        for (int i = 0; i < 6; i++) {
            System.out.println(chars[i]);
        }

        char[] arr = new char[]{'h', 'e', 'l', 'l', 'o'};
        String str2 = new String(arr);
        System.out.println(str2);
    }

    @Test
    public void test3() throws UnsupportedEncodingException {
        String str = "abc123中国";
        byte[] bytes = str.getBytes();//默认字符集
        System.out.println(Arrays.toString(bytes));
        byte[] gbks = str.getBytes("gbk");
        System.out.println(Arrays.toString(gbks));

        String str2 = new String(bytes);
        System.out.println(str);

        String str3 = new String(gbks, "gbk");
        System.out.println(str3);
    }
}
