package IDEADebug;

import org.junit.Test;

/**
 * @auther 齿轮
 * @create 2022-03-07-20:21
 */
public class IDEADebugTest {
    @Test
    public void testStringBuffer(){
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);//

        System.out.println(sb.length());//4

        System.out.println(sb);//"null"

        StringBuffer sb1 = new StringBuffer(str);//抛异常NullPointerException
        System.out.println(sb1);//

    }
}
