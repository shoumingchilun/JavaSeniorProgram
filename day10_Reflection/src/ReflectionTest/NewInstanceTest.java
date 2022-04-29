package ReflectionTest;

import org.junit.Test;

import java.util.Random;

/**
 * @auther 齿轮
 * @create 2022-03-23-14:50
 *
 * 通过反射创建运行时类的对象
 *
 */
public class NewInstanceTest {
    @Test
    public void test1() throws InstantiationException, IllegalAccessException {
        Class<Person> clazz = Person.class;
        //newInstance():调用此方法，创建对应的运行时类的对象（通过构造器实现，调用运行时类的空参构造器）
        //要求：
        //1、运行时类必须提供空参构造器
        //2、空参构造器的访问权限通常为public

        //javabean中要求提供一个public的空参构造器
        //原因：1、方便反射；2、子类创建运行时类时需要调用super()
        Person obj = clazz.newInstance();
        Object obj1 = new Person();
        System.out.println(obj1);

    }

    //体会反射的动态性
    @Test
    public void test2(){

        for(int i = 0;i < 100;i++){
            int num = new Random().nextInt(3);//0,1,2
            String classPath = "";
            switch(num){
                case 0:
                    classPath = "java.util.Date";
                    break;
                case 1:
                    classPath = "java.lang.Object";
                    break;
                case 2:
                    classPath = "ReflectionTest.Person";
                    break;
            }

            try {
                Object obj = getInstance(classPath);
                System.out.println(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    /*
    创建一个指定类的对象。
    classPath:指定类的全类名
     */
    public Object getInstance(String classPath) throws Exception {
        Class clazz =  Class.forName(classPath);
        return clazz.newInstance();
    }
}
