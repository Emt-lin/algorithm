package acwing;

/**
 * @author psl
 * @date 2020/7/1
 *          82. 圆圈中最后剩下的数字
 *          解题思路：O(n)
 *              约瑟夫问题
 *              当第一次去掉一个数（m-1）后，下一个数（m)开始又从0开始设置序号
 *              旧编号：m，m+1，m+2，m+3，....       f[i]
 *              新编号：0，1，  2，  3，.....        f[i - 1]
 *              所以旧编号 f[i] = 新编号 (f[i - 1] + m) % i
 */
public class LastRemaining {
    public int lastRemaining(int n, int m) {
        // 循环递推解法
        if (n == 1) return 0;
        // f[i]代表最后剩下的数字
        int[] f = new int[n + 1];
        //当只有0一个数的时候，就返回0
        f[1] = 0;
        for (int i = 2; i <= n; i ++){
            // 这里是对i取模，
            f[i] = (f[i - 1] + m) % i;
        }
        return f[n];

        // 方法二：递归解法
        // 当n=1时，f(n, m) = 0
        // 当n>1时，f(n, m) = [f(n-1, m) +m] % n
        /*if (n == 1) return 0;
        return (lastRemaining(n - 1, m) + m) % n;*/

    }
}
