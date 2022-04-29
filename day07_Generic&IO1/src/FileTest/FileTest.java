package FileTest;

import org.junit.Test;

import java.io.File;

/**
 * @auther 齿轮
 * @create 2022-03-17-14:18
 * <p>
 * File类的使用
 * <p>
 * 1、File类的一个对象代表一个文件或文件目录
 * 2、File类声明于java.io包下
 * 3、File类不涉及写入或读取文件内容的操作，需使用IO流完成
 * 4、File类的对象常作为参数传递到流的构造器中，指明操作的终点
 *
 */
public class FileTest {
    /*
     * 1、创建File类实例
     * File(String pathname);
     * File(String parentPath,String childPath);
     * File(File file, String childPath)
     * 2、
     * 相对路径：相较于某个路径下指明的路径
     * 绝对路径：包含盘符在内的文件或文件目录的路径
     *
     * 3、
     * 路径分隔符
     * windows：\\ (也可用/，会自动识别)
     * unix：/
     * */
    @Test
    public void test1() {
        //构造器1
        File file1 = new File("hello.txt");//相对路径，相对于当前Module
        File file2 = new File("D:\\编程文件\\Idea_文件\\workspace_Idea\\JavaSeniorProgram\\day07_Generic&IO1\\hello2.txt");//绝对路径
        System.out.println(file1);
        System.out.println(file2);

        //构造器2
        File file3 = new File("D:\\编程文件\\Idea_文件\\workspace_Idea", "JavaSeniorProgram");
        System.out.println(file3);

        //构造器3
        File file4 = new File(file3, "hi.txt");
        System.out.println(file4);
    }
}
