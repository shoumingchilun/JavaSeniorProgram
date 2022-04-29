package RandomAccessFileTest;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

/**
 * @auther 齿轮
 * @create 2022-03-19-16:34
 *
 * RandomAccessFile随机文件读写流
 * 1、直接继承于Object，实现了DataInput和DataOutput接口
 * 2、RandomAccessFile既可以作为输入流，又可以作为输出流
 * 3、RandomAccessFile作为输出流时，如果文件不存在，则自动创建文件；如果存在，则对原有文件进行覆盖（默认从头开始）
 * 4、可通过相关操作实现插入效果
 *
 */
public class RandomAccessFileTest {
    public static void main(String[] args) {

    }
    @Test
    public void test1(){
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            raf1 = new RandomAccessFile(new File("project.json"),"r");
            raf2 = new RandomAccessFile(new File("project2.json"),"rw");

            byte[] buffer = new byte[1024];
            int len;
            while((len = raf1.read(buffer))!=-1){
                raf2.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(raf1!=null)
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if(raf2!=null)
                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }
    @Test
    public void test2() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile("hello.txt","rw");
        raf1.seek(5);//將指针调到下标为5的位置
        raf1.write("xya".getBytes(StandardCharsets.UTF_8));
        raf1.close();
    }
    /*
    * 使用RandomAccessFile实现插入效果
    *
    * */
    @Test
    public void test3() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile("hello.txt","rw");
        raf1.seek(3);
        StringBuilder str = new StringBuilder((int)new File("hello.txt").length());
        //可将StringBuilder替换为ByteArrayOutputStream
        byte[] buffer = new byte[1024];
        int len;
        while((len = raf1.read(buffer))!=-1){
            str.append(new String(buffer,0,len));

        }
        raf1.seek(3);
        raf1.write("xyz".getBytes());

        raf1.write(str.toString().getBytes());

        raf1.close();
    }
}
