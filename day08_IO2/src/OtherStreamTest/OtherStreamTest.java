package OtherStreamTest;

import org.junit.Test;

import java.io.*;

/**
 * @auther 齿轮
 * @create 2022-03-18-14:45
 * <p>
 * 其他流的使用
 * 1、标准输入输出流
 * 2、打印流
 * 3、数据流
 */
public class OtherStreamTest {
    /*
     * 1、标准输入输出流：
     * 1.1
     * System.in:标准输入流，默认键盘输入
     * System.out:标准输出流，默认控制台输出
     * 1.2
     * System类的setIn():重新指定输入流
     *                     setOut():重新指定输出流
     * 1.3
     * 练习：使用System.in实现读取键盘输入，将输入转换为大写，遇到”exit“时退出程序
     *
     * 2、打印流：PrintStream和PrintWriter
     * 2.1提供一系列重载的print()和println()
     *
     * 3、数据流：DataInputStream和DataOutputStream
     * 作用：读取或写出基本数据类型的变量或字符串
     *
     * */
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);
            while(true){
                String data = br.readLine();
                if("exit".equalsIgnoreCase(data)){
                    System.out.println("程序结束");
                    break;
                }
                System.out.println(data.toUpperCase());

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void test1() throws IOException {

        DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));

        dos.writeUTF("我");
        dos.flush();
        dos.writeInt(23);
        dos.flush();
        dos.writeBoolean(true);
        dos.flush();

        dos.close();
    }
    /*将文件中存储的基本数据类型变量和字符串读取到内存中，保存在变量中。
注意点：读取不同类型的数据的顺序要与当初写入文件时，保存的数据的顺序一致！
 */
    @Test
    public void test2() throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"));

        System.out.println(dis.readUTF());
        System.out.println(dis.readInt());
        System.out.println(dis.readBoolean());

        dis.close();
    }
}
