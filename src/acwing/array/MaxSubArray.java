package acwing.array;

/**
 * @author psl
 * @date 2019/11/14
 *          55. 连续子数组的最大和
 *
 *
 *              解题思路：
 *                  本体是一个动态规划的问题，用一个s变量来表示
 *                  s：表示当前x变量 包括前一个变量的子数组 的最大值
 *                  如果s 大于 0，s += x
 *                  如果s 小于等于 0，s = x
 *              时间复杂度：
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int s = 0;
        for(int x : nums){
            if (s < 0) s = 0;
            s += x;
            res = Math.max(res, s);
        }
        return res;
    }
}
