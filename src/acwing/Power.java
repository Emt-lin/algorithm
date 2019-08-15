package acwing;

/**
 * @author psl
 * @date 2019/8/15
 *          27. 数值的整数次方
 * 实现函数double Power(double base, int exponent)，求base的 exponent次方。
 * 不得使用库函数，同时不需要考虑大数问题。
 * 注意样例1
 * 输入：10 ，2 输出：100
 *      解题思路：
 *          同时不需要考虑大数问题，所以直接连乘循环就行。就是注意当指数为负数时，要取倒数
 *      时间复杂度：O(n)
 */
public class Power {
    public double _Power(double base, int exponent){
        double res = 1;
        for (int i = 0; i < Math.abs(exponent); i ++){
            res *= base;
        }
        System.out.println();
        if (exponent < 0)  res = 1 / res;
        return res;
    }
}
