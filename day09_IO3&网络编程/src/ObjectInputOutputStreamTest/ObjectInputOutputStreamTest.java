package ObjectInputOutputStreamTest;

import org.junit.Test;

import java.io.*;

/**
 * @auther 齿轮
 * @create 2022-03-18-16:54
 * <p>
 * 对象流的使用：ObjectInputStream和ObjectOutputStream
 * 作用：存储和读取基本数据类型或对象的处理流
 * <p>
 * java对象可序列化需要满足：
 * 1、实现接口Serializable
 * 2、需要当前类提供一个全局常量serialVersionUID
 * 3、类内部的所有其他属性也必须可序列化
 * 4.序列化机制：
 * 对象序列化机制允许把内存中的Java对象转换成平台无关的二进制流，从而允许把这种
 * 二进制流持久地保存在磁盘上，或通过网络将这种二进制流传输到另一个网络节点。
 * 当其它程序获取了这种二进制流，就可以恢复成原来的Java对象。
 *
 * （static和transient修饰的成员变量不能序列化）
 *
 */
public class ObjectInputOutputStreamTest {
    /*
     * 序列化：将内存中的java对象保存到磁盘中或通过网络传输出去
     * 使用ObjectOutputStream实现
     * */
    @Test
    public void testObjectOutputStream() {
        ObjectOutputStream oos = null;
        try {
            //1.造文件、流
            oos = new ObjectOutputStream(new FileOutputStream("Object.data"));
            //2.写入操作
            oos.writeObject(new String("魔都"));
            oos.flush();
            oos.writeObject(new Person("王1", 32));
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null)
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    /*
     * 反序列化：将磁盘中的对象还原为内存中的一个java对象
     *
     * */
    @Test
    public void testObjectInputStream() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("Object.data"));
            Object obj = ois.readObject();
            String str = (String) obj;
            System.out.println(obj);
            obj = ois.readObject();
            System.out.println((Person) obj);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null)
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
