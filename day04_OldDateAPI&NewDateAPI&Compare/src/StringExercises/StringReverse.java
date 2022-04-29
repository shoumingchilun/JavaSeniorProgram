package StringExercises;

import org.junit.Test;

/**
 * @auther 齿轮
 * @create 2022-03-07-19:10
 * <p>
 * 将字符串中的指定位置进行反转，如"abcdefg"反转为"abfedcg"
 */
public class StringReverse {
    //一
    public String reverse(String str, int startIndex, int endIndex) {
        if (str == null) return null;
        char[] arr = str.toCharArray();
        for (int x = startIndex, y = endIndex; x < y; x++, y--) {
            char temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;
        }
        return new String(arr);
    }

    //二
    public String reverse2(String str, int startIndex, int endIndex) {
        if (str == null) return null;
        String reverseStr = str.substring(0, startIndex);
        for (int i = endIndex; i >= startIndex; i--) {
            reverseStr += str.charAt(i);
        }
        reverseStr += str.substring(endIndex + 1);
        return reverseStr;
    }

    //三
    public String reverse3(String str, int startIndex, int endIndex) {
        StringBuilder builder = new StringBuilder(str.length());
        builder.append(str.substring(0, startIndex));
        for (int i = endIndex; i >= startIndex; i--) {
            builder.append(str.charAt(i));
        }
        builder.append(str.substring(endIndex+1));
        return builder.toString();
    }

    @Test
    public void testReverse() {
        String str = "abcdefg";
        System.out.println(reverse(str, 2, 5));
    }

    @Test
    public void testReverse2() {
        String str = "abcdefg";
        System.out.println(reverse2(str, 2, 5));
    }

    @Test
    public void testReverse3() {
        String str = "abcdefg";
        System.out.println(reverse3(str, 2, 5));
    }
}
