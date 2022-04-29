package test;

/**
 * @auther 齿轮
 * @create 2022-04-03-9:23
 */
public class StringBufferTest {
    public static void main(String[] args) {
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        System.out.println(sb.length());
        System.out.println(sb);
//        System.out.println(str.length());
//        StringBuffer sb1 = new StringBuffer(str);
//        System.out.println(sb1);
        String str2 = String.valueOf(12.4);
        System.out.println(str2);
        double d2 = Double.valueOf(str2);
        System.out.println(d2);

    }

}
