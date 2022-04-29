package Lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @auther 齿轮
 * @create 2022-03-29-9:17
 * <p>
 * 消费型接口 Consumer<T>     void accept(T t)
 * 供给型接口 Supplier<T>     T get()
 * 函数型接口 Function<T,R>   R apply(T t)
 * 断定型接口 Predicate<T>    boolean test(T t)
 */
public class LambdaTest1 {
    @Test
    public void test1() {
        happyTime(500, (o1) -> System.out.println("肘，跟我进屋！开销：" + o1));
        Math.random();
    }

    public void happyTime(double money, Consumer<Double> con) {
        con.accept(money);
    }

    @Test
    public void test2() {
        List<String> list = Arrays.asList("北京", "南京", "东京", "王八坨子");
        List<String> list1 = filterString(list, (s) -> s.contains("京"));
        System.out.println(list1);

    }

    //根据给定规则过滤集合中字符串
    public List<String> filterString(List<String> list, Predicate<String> pre) {
        ArrayList<String> filterList = new ArrayList<>();
        for (String s : list) {
            if (pre.test(s)) {
                filterList.add(s);
            }
        }
        return filterList;
    }
}
