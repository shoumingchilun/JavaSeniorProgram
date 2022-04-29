package BufferedTest;

import org.junit.Test;

import java.io.*;

/**
 * @auther 齿轮
 * @create 2022-03-18-9:29
 * <p>
 * 1、缓冲流
 * BufferedInputStream
 * BufferedOutputStream
 * BufferedReader
 * BufferedWriter
 * <p>
 * 2、缓冲流的作用：提升流的读取、写入的速度
 * 原因：内部提供了一个缓冲区
 * <p>
 * 3、处理流就是“套接”在已有流的基础上
 */
public class BufferedTest {
    /*
     * 非文本文件的复制
     * */
    @Test
    public void testBufferStream() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1、造文件
            File srcFile = new File("38元.jpg");
            File destFile = new File("38元3.jpg");
            //2、造流
            //(1造节点流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            //(2造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //3、复制
            byte[] buffer = new byte[10];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4、流资源关闭
            //要求：先关闭外层流，后关闭内层流
            if (bos != null)
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (bis != null)
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            //说明：关闭外层流的同时，内层流也会自动关闭（所以内层流的关闭可以省略）
//            fos.close();
//            fis.close();
        }
    }

    //实现文件复制的方法
    public void copyFileWithBuffered(String srcPath, String destPath) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1、造文件
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);
            //2、造流
            //(1造节点流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            //(2造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //3、复制
            byte[] buffer = new byte[5];//5:1s;1024:0s
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4、流资源关闭
            //要求：先关闭外层流，后关闭内层流
            if (bos != null)
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (bis != null)
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            //说明：关闭外层流的同时，内层流也会自动关闭（所以内层流的关闭可以省略）
//            fos.close();
//            fis.close();
        }
    }

    @Test
    public void testCopyFileWithBuffered() {
        long start = System.currentTimeMillis();
        String srcPath = "C:\\Users\\齿轮\\Desktop\\MIME AND DASH.mp4";
        String destPath = "C:\\Users\\齿轮\\Desktop\\MIME AND DASH3.mp4";
        copyFileWithBuffered(srcPath, destPath);
        long end = System.currentTimeMillis();
        System.out.println("复制花费时间：" + (end - start) / 1000 + "秒");
    }

    //使用BufferedReader和BufferedWriter实现文本文件复制
    @Test
    public void testBufferedReaderWriter() {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            //创建文件和相应的流
            br = new BufferedReader(new FileReader(new File("project.json")));
            bw = new BufferedWriter(new FileWriter(new File("project2.json")));
            //读写操作
            //方式一：char[]数组
//            char[] buffer = new char[1024];
//            int len;
//            while((len = br.read(buffer))!=-1){
//                bw.write(buffer,0,len);
//    //            bw.flush();
//            }
            //方式二：使用String
            String data;
            while ((data = br.readLine()) != null) {
                //方法一：
//                bw.write(data+'\n');//data不包含换行符
                //方法二：
                bw.write(data);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流资源
            if (bw != null)
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (br != null)
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
