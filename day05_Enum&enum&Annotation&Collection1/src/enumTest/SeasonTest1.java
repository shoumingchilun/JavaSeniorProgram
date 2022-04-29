package enumTest;

/**
 * @auther 齿轮
 * @create 2022-03-09-10:46
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 summer = Season1.SUMMER;
        System.out.println(summer);
        System.out.println(Season1.class.getSuperclass());
        System.out.println(Season1.SPRING.getSeasonName());
        Season1[] values = Season1.values();
        //values()
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }
        //valeOf()
        System.out.println(Season1.valueOf("WINTER"));
    }
}

//方法二
//enum默认继承于java.lang.Enum
enum Season1 {
    //1.多个对象之间用逗号隔开，末尾用分号结束
    SPRING("春", "春困") {
        @Override
        public String getSeasonName() {
            return "???";
        }
    },
    SUMMER("春", "夏乏"),
    AUTUMN("春", "秋打盹"),
    WINTER("春", "冬眠");
    //2.声明Season对象的属性：private final
    private final String seasonName;
    private final String seasonDesc;

    //3.私有化构造器并赋值
    private Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //4.其他述求
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

//    public String toString(){
//        return "Season1"+seasonName+":\t"+seasonDesc;
//    }


//    //声明Season对象的属性:private final
//    private final String seasonName;
//    private final String seasonDesc;
//
//    //私有化构造器,并赋值
//    public Season1(String seasonName, String seasonDesc) {
//        this.seasonName = seasonName;
//        this.seasonDesc = seasonDesc;
//    }
//
//    //提供当前类的多个对象
//    public static final Season1 SPRING = new Season1("春","春困");
//    public static final Season1 SUMMER = new Season1("春","夏乏");
//    public static final Season1 AUTUMN = new Season1("春","秋打盹");
//    public static final Season1 WINTER = new Season1("春","冬眠");
//
//    //其他述求：.......
//
//    public String getSeasonName() {
//        return seasonName;
//    }
//
//    public String getSeasonDesc() {
//        return seasonDesc;
//    }
//
//    public String toString(){
//        return "Season1"+seasonName+":\t"+seasonDesc;
//    }
}