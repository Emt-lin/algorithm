package acwing;

/**
 * @author psl
 * @date 2020/7/2
 *          84. 求1+2+…+n
 *          解题思路：
 *
 */
public class GetSum {
    public int getSum(int n) {
        int res = n;
        // 这里是利用语法特性。A && B：当A为false时，B就不会执行
        // A || B: 当A为true时，B就不会执行
//        if (n > 0) res += getSum(n - 1);
        boolean flag = n > 0 && (res += getSum(n - 1)) > 0;
        return res;
    }
}
