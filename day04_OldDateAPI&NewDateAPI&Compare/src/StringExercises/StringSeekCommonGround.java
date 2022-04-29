package StringExercises;

import org.junit.Test;

/**
 * @auther 齿轮
 * @create 2022-03-07-19:54
 * <p>
 * 求两个字符串中最大相同子串(默认无相同长度)
 */
public class StringSeekCommonGround {
    public String getMaxSameString(String str1, String str2) {
        if (str1 == null || str2 == null) return null;
        String MaxStr = (str1.length() >= str2.length()) ? str1 : str2;
        String MinStr = (str1.length() >= str2.length()) ? str2 : str1;

        for (int i = 0; i < MinStr.length(); i++) {
            for (int x = 0, y = MinStr.length()-i; y <= MinStr.length(); x++, y++) {
                String subStr = MinStr.substring(x, y);
                if (MaxStr.contains(subStr)) {
                    return subStr;
                }
            }
        }
        return null;
    }

    @Test
    public void testGetMaxSameString() {
        String str1 = "avarbaehellohelleadvgr";
        String str2 = "favhellovahelle";
        System.out.println(getMaxSameString(str1, str2));
    }
}
