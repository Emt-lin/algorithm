package acwing.string;

/**
 * @author psl
 * @date 2020/7/3
 *          87. 把字符串转换成整数
 *          解题思路：
 *
 */
public class StrToInt {
    public int strToInt(String str) {
        if (str == null || str.length() == 0) return 0;
        int k = 0;
        while (k < str.length() && str.charAt(k) == ' ') k ++;
        long  number = 0;
        // 代表是否是负数
        boolean is_minus = false;
        if (str.charAt(k) == '+') k ++;
        else if (str.charAt(k) == '-'){
            k ++;
            is_minus = true;
        }
        while (k < str.length() && str.charAt(k) >= '0' && str.charAt(k) <= '9'){
            number = number * 10 + str.charAt(k) - '0';
            k ++;
        }
        if (is_minus) number *= -1;
        if (number > Integer.MAX_VALUE) number = Integer.MAX_VALUE;
        if (number < Integer.MIN_VALUE) number = Integer.MIN_VALUE;

        return  (int) number;
    }
}
