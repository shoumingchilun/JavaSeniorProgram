package ReflectionTest;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @auther 齿轮
 * @create 2022-03-21-17:08
 *
 * ？：反射与面向对象的封装性
 *
 * ？：通过直接new对象的方式||反射的方式调用公共结构
 * 建议：直接new。反射具有动态性
 *
 * Class实例对应一个运行时类
 * Class实例可以是
 * （1）class：
 * 外部类，成员(成员内部类，静态内部类)，局部内部类，匿名内部类
 * （2）interface：接口
 * （3）[]：数组
 * （4）enum：枚举
 * （5）annotation：注解@interface
 * （6）primitive type：基本数据类型
 * （7）void
 */
public class ReflectionTest {
    //无反射时可进行的操作
    @Test
    public void test1() {
        //1、创建对象
        Person p1 = new Person("Tom", 21);

        //2、通过对象调用内部属性、方法
        p1.age = 20;
        System.out.println(p1);
        p1.show();

        //在Person类的外部不能通过Person类的对象调用其内部私有结构
        //如name，showNation()

        //使用反射后可进行的操作
    }


    //使用反射后可进行的操作
    @Test
    public void test2() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        //1、通过反射创建Person对象
        Class Person_class = Person.class;
        Constructor cons = Person_class.getConstructor(String.class, int.class);
        Object obj = cons.newInstance("Tom", 12);
        Person p = (Person) obj;
        System.out.println(p);
        //2、通过反射调用对象指定的属性、方法
        //属性
        Field age = Person_class.getDeclaredField("age");
        age.set(p, 10);
        System.out.println(p);
        //方法
        Method show = Person_class.getDeclaredMethod("show");
        show.invoke(p);
        //通过反射，可以调用Person类的私用结构
        //私有构造器
        Constructor cons1 = Person_class.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person jorry = (Person) cons1.newInstance("Jorry");
        System.out.println(jorry);
        //私有属性
        Field name = Person_class.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p,"Xu");
        System.out.println(p);
        //私有方法
        Method showNation = Person_class.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation =(String) showNation.invoke(p, "China");
        System.out.println(nation);
        //静态方法
        Method showDesc = Person_class.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        showDesc.invoke(Person_class);

    }


    //获取Class实例
    @Test
    public void test3() throws ClassNotFoundException {
        //1、调用运行时类的属性：.class
        Class clazz1 = Person.class;
        System.out.println(clazz1);
        //2、通过运行时类的对象，调用getClass()
        Class clazz2 = (new Person()).getClass();
        System.out.println(clazz2);
        //3、调用Class的静态方法：forName(String classPath)
        Class clazz3 = Class.forName("ReflectionTest.Person");
        System.out.println(clazz3);
        System.out.println(clazz1 == clazz2);//获取的是内存中同一个运行时类，故为true
        System.out.println(clazz1 == clazz3);
        //4、使用类加载器：ClassLoader（了解
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("ReflectionTest.Person");
        System.out.println(clazz4 == clazz1);
    }
}
