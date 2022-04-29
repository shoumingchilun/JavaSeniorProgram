package FileInputOutputStreamTest;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @auther 齿轮
 * @create 2022-03-18-8:26
 * <p>
 * 测试FileInputStream和FileOutputStream的使用
 * 使用字节流处理文本文件可能出现乱码
 * 结论：
 * 1、对于文本文件(.txt，.java，.c，.cpp，......)，使用字符流
 * 2、对于非文本文件，使用字节流
 */
public class FileInputOutputStreamTest {
    @Test
    public void testFileInputStream() {
        FileInputStream fis = null;
        try {
            //1、造文件
            File file = new File("hello.txt");
            //2、造流
            fis = new FileInputStream(file);
            //3、读数据
            byte[] buffer = new byte[5];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                String str = new String(buffer, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4、关闭流资源
            try {
                if (fis != null) ;
                {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //复制图片文件
    @Test
    public void testFileInputOutputStream() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcFile = new File("38元.jpg");
            File destFile = new File("38元1.jpg");

            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            //复制
            byte[] buffer = new byte[5];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null)
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (fis != null)
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
    //指定路径下文件的复制
    public void copyFile(String srcPath,String destPath ){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            //复制
            byte[] buffer = new byte[102400];//5:280s;1024:2s;102400:0s
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null)
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (fis != null)
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
    @Test
    public void testCopyFile(){
        long start = System.currentTimeMillis();
        String srcPath = "C:\\Users\\齿轮\\Desktop\\MIME AND DASH.mp4";
        String destPath = "C:\\Users\\齿轮\\Desktop\\MIME AND DASH2.mp4";
        copyFile(srcPath,destPath);
        long end = System.currentTimeMillis();
        System.out.println("复制花费时间："+ (end-start)/1000 + "秒");
    }
}
