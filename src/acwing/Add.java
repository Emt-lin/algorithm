package acwing;

/**
 * @author psl
 * @date 2020/7/2
 *          85. 不用加减乘除做加法
 *          解题思路：
 *              考虑一位数相加：A+B = 进位C= A&B + 末位D = A ^ B（A异或B）
 *               A + B = 没算进位的和 + 进位的和(要左移一位，因为都是往高位进一位)
 */
public class Add {
    public int add(int num1, int num2) {
        // 循环结束条件，每一次carry都要向左移一位，然后num2 = carry，所以每次都要增加0，最多32次就全为0
        while (num2 != 0){
            // 首先，sum表示计算两个数的不算进位的和，第一次计算sum，相当于两个数所有二进制位不算进位的和
            // 从第二次开始计算时，都是上一次的sum + carry的和（不包含进位）
            int sum = num1 ^ num2;
            // 首先，carry表示只计算两个数的进位的和
            // 从第二次开始计算时，都是上一次的sum + carry的进位和。直到进位和为0时，结束循环
            int carry = (num1 & num2) << 1;
            //
            num1 = sum;
            num2 = carry;
        }
        return num1;
    }
}
