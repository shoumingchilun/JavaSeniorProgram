package TCPTest;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @auther 齿轮
 * @create 2022-03-20-11:51
 *
 * 客户端发送文件到服务端，服务端将文件保存到本地
 *
 *
 */
public class TCPTest2 {
    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
        try {
            //1、造服务端的socket
            socket = new Socket(InetAddress.getByName("127.0.0.1"),59999);
            //2、造输出流指向服务端
            os = socket.getOutputStream();
            //3、造输入流读取本地文件
            fis = new FileInputStream("不服来咬我？.jpg");
            //4、进行读写操作
            byte[] buffer = new byte[1024];
            int len;
            while((len = fis.read(buffer))!=-1){
                os.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //5、关闭流资源
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void server() throws IOException {

        ServerSocket ss = new ServerSocket(59999);

        Socket socket = ss.accept();
        InputStream is = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream("不服来咬我？2.jpg");

        byte[] buffer = new byte[1024];
        int len;
        while((len=is.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }
        fos.close();
        is.close();
        socket.close();
        ss.close();
    }
}
