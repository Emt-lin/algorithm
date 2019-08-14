package acwing;

/**
 * @author psl
 * @date 2019/8/14
 *          26. 二进制中1的个数
 * 输入一个32位整数，输出该数二进制表示中1的个数。
 * 注意：  负数在计算机中用其绝对值的补码来表示。
 * 样例1  输入：9    输出：2
 * 解释：9的二进制表示是1001，一共有2个1。
 * 样例2  输入：-2   输出：31
 * 解释：-2在计算机里会被表示成11111111111111111111111111111110，一共有31个1。
 */
public class NumberOf1 {
    //直接点用方法
    public int NumberOf1(int n){
        return Integer.bitCount(n);
        /*
        c++实现
            //主要是c++里面负数右移后，最高位补1。无符号数，右移最高位补0
           unsigned int _n = n;
           int s = 0;
           while(_n) s += s & 1 ,_n >>= 1;
           return s;
         */
    }
}
