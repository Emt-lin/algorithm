package acwing;

import java.util.LinkedList;

/**
 * @author psl
 * @date 2019/11/14
 *          56. 从1到n整数中1出现的次数
 *
 *
 *              解题思路：
 *                  每一位中1的个数（比如：13015，找出万位、千位等中1的个数）
 *                  n：abcdef，最终结果：res = 0
 *                       当前到 c 位来了
 *                      一、高位为 00 ~ ab - 1，ab * 1000 个1
 *                      二、高位为ab时：
 *                          （1） c 等于 0时，0 个1
 *                          （2） c等于 1时，0~def 个1
 *                          （3） c 大于 1时，1000 个1
 *              时间复杂度：O(log^n 的平方)，容易改成O(log^n)，把left，right，t预处理出来，然后用的时候查表
 *              图片思路： acwing 56.png
 */
public class NumberOf1Between1AndN_Solution {
    public int numberOf1Between1AndN_Solution(int n) {
        if (n == 0) return 0;
        LinkedList<Integer> number = new LinkedList<>();
        int res = 0;
        //把n的每一位数存放到number栈中
        while(n != 0){
            int num = n % 10;
            number.add(num);
            n /= 10;
        }
        //从最高位开始寻找1的个数
        for (int i = number.size() - 1; i >= 0; i -- ){
            //用left记录当前位左边的个数，right记录当前位右边的个数，t为 0~left-1 或 当前位的数大于1时，做准备
            int left = 0, right = 0, t = 1;
            //计算左边数的个数
            for (int j = number.size() - 1; j > i; j --) left = left * 10 + number.get(j) ;
            //计算右边数的个数
            for (int j = i - 1; j >= 0; j --) {
                right = right * 10 + number.get(j);
                t *= 10;
            }
            //计算 0 ~ left-1，1的个数
            res += left * t;
            //等于1时，右边就只有right 个1
            if (number.get(i) == 1) res += right + 1;
            //当前位大于 1 时，
            else if (number.get(i) > 1) res += t;
        }
        return res;
    }
}
