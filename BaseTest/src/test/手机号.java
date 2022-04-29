package test;

import java.util.Scanner;
import java.util.function.Predicate;

/**
 * @auther 齿轮
 * @create 2022-04-05-10:06
 */
public class 手机号 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Predicate<String> p1 = (str) -> {
            if (str.length() != 11) return false;
            try {
                Long.valueOf(str);
            } catch (NumberFormatException e) {
                return false;
            }
            return true;
        };
        String str = scanner.nextLine();
        if (!p1.test(str)) throw new RuntimeException("输入格式错误");
        String str2 = str.substring(0, 3) + "****" + str.substring(7);
        System.out.println(str2);

        System.out.println(5.5%3.1);
    }
}
