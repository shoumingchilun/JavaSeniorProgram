package ReflectionTest;

/**
 * @auther 齿轮
 * @create 2022-03-21-17:08
 */
public class Person {
    private String name;
    public int age;

    public static void showDesc(){
        System.out.println("我很可爱，__________");
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    private Person(String name) {
        this.name = name;
    }
    public void show(){
        System.out.println("我是Person");
    }
    private String showNation(String nation){
        System.out.println(name+"的国籍是" + nation);
        return nation;
    }
}
