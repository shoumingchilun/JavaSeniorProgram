package StringBufferBuilderTest;

import org.junit.Test;

/**
 * @auther 齿轮
 * @create 2022-03-06-19:18
 *
 *
 * String/StringBuffer/StringBuilder异同:
 * String:不可变的字符序列，底层使用byte[]存储
 * StringBuffer:可变的字符序列，线程安全，效率低，底层使用byte[]存储
 * StringBuilder:可变的字符序列，线程不安全，效率高，底层使用byte[]存储
 *
 * StringBuffer/StringBuilder常用方法:
 * StringBuffer的常用方法：
 * StringBuffer append(xxx)：提供了很多的append()方法，用于进行字符串拼接
 * StringBuffer delete(int start,int end)：删除指定位置的内容
 * StringBuffer replace(int start, int end, String str)：把[start,end)位置替换为str
 * StringBuffer insert(int offset, xxx)：在指定位置插入xxx
 * StringBuffer reverse() ：把当前字符序列逆转
 * public int indexOf(String str)
 * public String substring(int start,int end):返回一个从start开始到end索引结束的左闭右开区间的子字符串
 * public int length()
 * public char charAt(int n )
 * public void setCharAt(int n ,char ch)
 *        总结：
 *         增：append(xxx)
 *         删：delete(int start,int end)
 *         改：setCharAt(int n ,char ch) / replace(int start, int end, String str)
 *         查：charAt(int n )
 *         插：insert(int offset, xxx)
 *         长度：length();
 *         *遍历：for() + charAt() / toString()
 *
 *
 */
public class StringBufferBuilderTest {
    @Test
    public void test1(){
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(0,'m');
        System.out.println(sb1);
    }


}
