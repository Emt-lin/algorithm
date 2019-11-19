package acwing;

/**
 * @author psl
 * @date 2019/11/19
 *          57. 数字序列中某一位的数字
 *
 *
 *
 *
 *          解题思路：
 *              1、确定是几位数        n - 10 - 90 * 2 - 900 * 3，一位数：10，两位数：90，三位数：900
 *              2、确定是几位数的第几个数
 *              3、属于那个数的第几位
 *          时间复杂度：O(log n)
 */
public class DigitAtIndex {
    public int digitAtIndex(int n) {
        n ++; //代表0这个数
        n --; //把0减掉，这样1位数变为9个，为了统一
        //i代表位数，s代表这个位数的个数，base代表当前位数的第一个数          => 第一步
        long  i = 1, s = 9, base = 1;
        while (n > i * s){
            n -= i * s;
            i ++;
            s *= 10;
            base *= 10;
        }
        //这里要上取整，因为有余数的话，就说明在下一个数 n / i 的上取整 == (n + i - 1) / i     => 第二步
        int number = (int)(base + (n + i - 1) / i - 1);
        //不等于0，就是余数，等于0，就是第i位           这个代表number的r位       => 第三步
        int r = (n % i != 0 ) ? (int)(n % i) : (int)i;
        //number的第r位，就是去掉 number的i-r位
        for(int j = 0; j < i - r; j ++) number /= 10;

        return number % 10;
    }
}
