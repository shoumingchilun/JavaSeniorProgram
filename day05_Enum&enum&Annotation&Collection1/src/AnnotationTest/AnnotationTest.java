package AnnotationTest;

/**
 * @auther 齿轮
 * @create 2022-03-09-17:25
 * <p>
 * 框架 = 注解 + 反射 + 设计模式
 * <p>
 * jdk5.0新增
 * <p>
 * 一、理解
 * Annotation 其实就是代码里的特殊标记, 这些标记可以在编译, 类加
 * 载, 运行时被读取, 并执行相应的处理。通过使用 Annotation, 程序员
 * 可以在不改变原有逻辑的情况下, 在源文件中嵌入一些补充信息。
 * <p>
 * 二、用例:
 * （1生成文档相关的注解
 * （2在编译时进行格式检查:
 * -@Override：限定重写父类方法
 * -@Deprecated：方法已经过时
 * -@SuppressWarnings：抑制编译器警告 （3跟踪代码依赖性，实现替代配置文件功能
 * <p>
 * 三、自定义注解(参照SuppressWarnings
 * 1.注解声明为@interface
 * 2.内部定义成员，通常使用value表示
 * 3.可以指定成员默认值，使用default定义
 * 4.如果没有自定义成员，表明为标识作用
 * <p>
 * 如果注解有成员，在使用注解时，需要指明成员的值
 * 自定义注解必须配上注解的信息处理流程（使用反射），才有意义
 * 自定义注解通常会指明两个元注解：Retention、Target
 * <p>
 * 四、jdk定义的4种元注解
 * 元注解：对现有注解进行解释说明的注解
 * Retention：指定该 Annotation 的生命周期（SOURCE、CLASS（默认）、RUNTIME）
 * Target：指定被修饰的 Annotation 能用于修饰哪些程序元素
 * Documented：指定被该元 Annotation 修饰的 Annotation 类将被javadoc 工具提取成文档
 * Inherited：被它修饰的 Annotation 将具有继承性。如果某个类使用了被@Inherited 修饰的 Annotation, 则其子类将自动具有该注解。
 * <p>
 * 五、通过反射获得注解信息
 * ......（会个屁，笑死
 * <p>
 * 六、jdk8 注解的新特性：可重复注解、类型注解
 * 可重复注解：① 在MyAnnotation上声明@Repeatable，成员值为MyAnnotations.class
 *                     ② MyAnnotation的Target和Retention等元注解与MyAnnotations相同。
 *
 * 类型注解：ElementType.TYPE_PARAMETER 表示该注解能写在类型变量的声明语句中（如：泛型声明）。
 *                    ElementType.TYPE_USE 表示该注解能写在使用类型的任何语句中。
 *
 */
//@MyAnnotation(value = "hello1")
//@MyAnnotation(value = "hello2")
//旧写法
@MyAnnotations({@MyAnnotation(value = "hello1"),@MyAnnotation(value = "hello2")})
public class AnnotationTest {

}

class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void walk() {
        System.out.println("人走路");
    }

    public void eat() {
        System.out.println("人吃饭");
    }
}

interface Info {
    @SuppressWarnings("unused")
    void show();
}

class Student extends Person implements Info {
    @Override
    public void walk() {
        System.out.println("学生走路");
    }

    @Override
    public void show() {

    }
}