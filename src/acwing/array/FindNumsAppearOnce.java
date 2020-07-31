package acwing.array;

/**
 * @author psl
 * @date 2020/6/28
 *              73. 数组中只出现一次的两个数字
 *              解题思路：
 *                  采用异或运算
 *                  1、让集合中所有元素进行异或，结果 = x 异或 y。因为相同的元素异或为0
 *                  2、找出上一步结果中二进制的某一位为1的那位，假设是第k位。（某一位为1，就代表x，y在那一位不相同，可能分别为0,1）
 *                  3、根据第k位，就把集合中的元素分为两个集合，然后x，y分别就在这两个集合中。
 *                  4、然后两个集合分别做异或运算，就分别求出了x，y
 *
 */
public class FindNumsAppearOnce {
    public int[] findNumsAppearOnce(int[] nums) {
        int sum = 0; // x ^ y
        // 求出所有元素的异或
        for(int i : nums) sum ^= i;
        int k = 0;
        // 代表sum右移k位，然后和1相与。
        while ((sum >> k & 1) == 0) k++;
        int first = 0;
        for(int x : nums){
            // 这就求出第k位为1的所有元素的异或
            if ((x >> k & 1) == 1)
                first ^= x;
        }
        // sum ^ first，sum是所有元素的异或，然后再与第一部分元素进行异或就求出第二部分元素异或的结果
        return new int[]{first, sum ^ first};
    }
}
