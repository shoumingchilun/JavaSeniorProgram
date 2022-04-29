package FileReaderWriterTest;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @auther 齿轮
 * @create 2022-03-17-21:50
 * <p>
 * 一、流的分类
 * 1.操作数据单位：字节流、字符流
 * 2.数据的流向：输入流、输出流
 * 3.流的角色：节点流、处理流
 * <p>
 * 二、流的体系结构
 * 抽象基类             节点流（文件流）            缓冲流（处理流的一种）
 * InputStream         FileInputStream               BufferedInputStream
 * OutputStream      FileOutputStream           BufferedOutputStream
 * Reader                  FileReader                       BufferedReader
 * Writer                   FileWriter                         BufferedWriter
 */
public class FileReaderWriterTest {
    public static void main(String[] args) {
        File file = new File("hello.txt");//相较于当前工程
        System.out.println(file.getAbsoluteFile());
        File file2 = new File("day08_IO2\\hello.txt");
        System.out.println(file2.getAbsoluteFile());
    }

    //读取hello.txt内的字符并输出
    @Test
    public void testFileReader() {
        FileReader fr = null;
        try {
            //1、实例化File类的对象，指明要操作的对象
            File file = new File("hello.txt");//相较于当前Module
            //2、提供具体的流
            fr = new FileReader(file);//读入文件若不存在，则抛出FileNotFoundException异常
            //3、数据的读入
            //read()返回文件的一个字符，如果达到末尾，返回-1
            int data = fr.read();
            while (data != -1) {
                System.out.println((char) data);
                data = fr.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {//为保证流资源一定可以执行关闭操作，使用try-catch-finally操作
            //4、流的关闭操作
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    //对read()操作升级：使用read的重载方法
    @Test
    public void testFileReader1() {
        FileReader fr = null;
        try {
            //1、File类的实例化
            File file = new File("hello.txt");
            //2、FileReader流的实例化
            fr = new FileReader(file);
            //3、读入操作
            //返回每次读入到cBuffer数组中字符的个数，如果达到文化末尾，返回-1
            char[] cBuffer = new char[5];
            int len;
            while ((len = fr.read(cBuffer)) != -1) {
                //错误
//                for (char c : cBuffer) {
//                    System.out.println(c);
//                }
                //正确
//                for (int i = 0; i < len; i++) {
//                    System.out.println(cBuffer[i]);
//                }
                //方式二
                //错误
//                String str = new String(cBuffer);
//                System.out.print(str);
                //正确
                String str = new String(cBuffer, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4、资源关闭
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    //内存写出数据到硬盘文件
    //1、输出操作，对应File如果不存在，则自动创建此文件；如果存在
    //如果调用FileWriter(file,false)，则对原文件覆盖
    //如果调用FileWriter(file,true)，则在原有文件基础上追加内容

    @Test
    public void testFileWriter() throws IOException {
        //1、提供File类对象，指明写出到的文件
        File file = new File("hello1.txt");
        //2、提供fileWriter的对象，用于数据写出
        FileWriter fw = new FileWriter(file, true);
        //3、写出操作
        fw.write("I have a Dream!\n");
        fw.write("you need to have a dream, too.");
        //4、资源流关闭
        fw.close();
    }

    //文件复制
    @Test
    public void testFileReaderWriter() {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            //1、创建两个File对象，指明读入和写出对象
            File srcFile = new File("hello.txt");
            File destFile = new File("hello2.txt");
            //2、创建输入流、输出流对象
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);
            //3、数据读入、写出操作
            char[] cBuffer = new char[5];
            int len;
            while ((len = fr.read(cBuffer)) != -1) {
                fw.write(cBuffer, 0, len);//每次写出len个字符
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4关闭流资源
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try{
                if (fw != null)
                    fw.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
