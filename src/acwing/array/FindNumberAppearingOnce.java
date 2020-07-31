package acwing.array;

/**
 * @author psl
 * @date 2020/6/28
 *          74. 数组中唯一只出现一次的数字
 *          解题思路：
 *              方法一：
 *              方法二：采用状态机的思想
 */
public class FindNumberAppearingOnce {
    public int findNumberAppearingOnce(int[] nums) {
        int ans = 0;
        // 遍历每一个数的二进制表示的每一位
        for (int i = 31; i >= 0; i --){
            int cnt = 0;
            for (int x : nums){
                if ((x >> i & 1) == 1) cnt++;
            }
            // 如果当前二进制位的1的个数，是模3余1的话，说明待求数的当前二进制位为1
            if (cnt % 3 == 1) ans = ans * 2 + 1;
            // 否则当前位为0
            else ans = ans * 2;
        }
        return ans;



        //方法二
/*        int ones = 0, twos = 0;
        for (int x : nums){
            ones = (ones ^ x) & ~twos;
            twos = (twos ^ x) & ~ones;
        }
        return ones;*/
    }
}
