package TCPTest;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

/**
 * @auther 齿轮
 * @create 2022-03-21-16:11
 * <p>
 * UDPt协议的网络传输
 */
public class UDPTest {
    //发送端
    @Test
    public void sender() throws IOException {
        DatagramSocket socket = new DatagramSocket();

        String str = "Sender:UDP_String";
        byte[] data = str.getBytes();
        InetAddress inet = InetAddress.getLocalHost();

        DatagramPacket packet = new DatagramPacket(data,0,data.length,inet,49090);

        socket.send(packet);

        socket.close();

    }

    //接受端
    @Test
    public void receiver() throws IOException {
        DatagramSocket socket = new DatagramSocket(49090);
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length);
        socket.receive(packet);

        System.out.println(new String(packet.getData(),0,packet.getLength()));
        socket.close();
    }
}
