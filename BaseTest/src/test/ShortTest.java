package test;

/**
 * @auther 齿轮
 * @create 2022-03-23-19:11
 */
public class ShortTest {
    public static void main(String[] args) {
        short s = 5;
        s= (short) (s-2);
        System.out.println(-14>>>2);
        int[] a = {1,2,3};
        char[] b = {'a','b','c'};
        System.out.println(a);
        System.out.println(b);
        MainTest.main(null);
        Man man = new Man();
        man.help();
    }
}
class MainTest{
    public static void main(String[] args) {
        System.out.println("FuCk y0u");
    }
}
interface Playable {
    void play();
}
interface Bounceable {
    void play();
}
interface Rollable extends Playable, Bounceable {
    Ball ball = new Ball("PingPang");
}

class Ball implements Rollable {
    private String name;
    public String getName() {
        return name;
    }
    public Ball(String name) {
        this.name = name;
    }
    public void play() {
//        ball = new Ball("Football");
        System.out.println(ball.getName());
    }
}
interface Filial {// 孝顺的
    default void help() {
        System.out.println("老妈，我来救你了");
    }
}
interface Spoony {// 痴情的
    default void help() {
        System.out.println("媳妇，别怕，我来了");
    }
}
class Man implements Filial, Spoony {
    @Override
    public void help() {
        System.out.println("我该怎么办呢？");
        Filial.super.help();
        Spoony.super.help();
    }
}