package enumTest;

/**
 * @auther 齿轮
 * @create 2022-03-09-10:30
 *
 * 枚举类：
 * 1、有限个对象
 * 2、宜用于定义一组常量
 * 3、如果枚举类里只有一个对象。则可以作为单例模式的实现方式
 *
 * 如何定义：
 * 方式一：自定义枚举类（jdk5.0之前）
 * 方式二：使用enum关键字
 *
 * Enum类中的常用方法：
 *      values():返回枚举类型的对象数组。
 *      valueOf(String objName):返回枚举类中对象名是objName的对象。
 *      toString():返回枚举类对象的名称
 *
 * 枚举类实现接口
 * 一、实现接口，在enum类中实现抽象方法
 * 二、实现接口，在每一个对象中实现抽象方法
 */
public class SeasonTest {
    public static void main(String[] args) {

    }
}
//方式一
class Season{
    //声明Season对象的属性:private final
    private final String seasonName;
    private final String seasonDesc;

    //私有化构造器,并赋值
    private Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //提供当前类的多个对象
    public static final Season SPRING = new Season("春","春困");
    public static final Season SUMMER = new Season("春","夏乏");
    public static final Season AUTUMN = new Season("春","秋打盹");
    public static final Season WINTER = new Season("春","冬眠");

    //其他述求：.......

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    public String toString(){
        return "Season"+seasonName+":\t"+seasonDesc;
    }
}