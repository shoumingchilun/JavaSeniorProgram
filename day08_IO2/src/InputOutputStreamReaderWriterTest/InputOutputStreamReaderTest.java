package InputOutputStreamReaderWriterTest;

import org.junit.Test;

import java.io.*;

/**
 * @auther 齿轮
 * @create 2022-03-18-14:02
 * <p>
 * 处理流（二）：转换流的使用
 * 1、转换流：属于字符流
 * InputStreamReader：将一个字节的输入流转换为字符的输入流
 * OutputStreamWriter：将一个字符的输出流转换为字节的输出流
 * 2、作用：提供字节流和字符流之间的转换
 * <p>
 * 3、解码：字节、字节数组->字符数组、字符串
 * 编码：字符数组、字符串->字节、字节数组
 * <p>
 * 4、字符集
 *  ASCII：美国标准信息交换码。
 *     用一个字节的7位可以表示。
 *  ISO8859-1：拉丁码表。欧洲码表
 *     用一个字节的8位表示。
 *  GB2312：中国的中文编码表。最多两个字节编码所有字符
 *  GBK：中国的中文编码表升级，融合了更多的中文文字符号。最多两个字节编码
 *  Unicode：国际标准码，融合了目前人类使用的所有字符。为每个字符分配唯一的字符码。所有的文字都用两个字节来表示。
 *  UTF-8：变长的编码方式，可用1-4个字节来表示一个字符。
 */
public class InputOutputStreamReaderTest {

    //InputStreamReader实现字节的输入流到字符的输入流
    @Test
    public void test1() throws IOException {
        FileInputStream fis = new FileInputStream("project.json");
        //参数2指明字符集，具体使用哪个字符集取决于文件保存时使用的字符集
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        char[] cBuffer = new char[20];
        int len;
        while ((len = isr.read(cBuffer)) != -1) {
            String str = new String(cBuffer, 0, len);
            System.out.print(str);
        }
        isr.close();
    }

    //综合使用InputStreamReader和OutputStringWriter
    @Test
    public void test2() throws IOException {
        //造文件、流
        File file1 = new File("project.json");
        File file2 = new File("project_GBK.json");
        FileInputStream fis = new FileInputStream(file1);
        FileOutputStream fos = new FileOutputStream(file2);
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        OutputStreamWriter osw = new OutputStreamWriter(fos, "GBK");
        //读写
        char[] cBuffer = new char[20];
        int len;
        while ((len = isr.read(cBuffer)) != -1) {
            osw.write(cBuffer, 0, len);
        }
        //关闭流资源
        isr.close();
        osw.close();

    }
}
