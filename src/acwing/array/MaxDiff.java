package acwing.array;

/**
 * @author psl
 * @date 2020/7/2
 *          83. 股票的最大利润
 *          解题思路：O(n)
 *
 */
public class MaxDiff {
    public int maxDiff(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = 0;
        // 用minv来保存前i-1天的最小值
        for (int i = 1, minv = nums[0]; i < nums.length; i ++){
            res = Math.max(res, nums[i] - minv);
            minv = Math.min(minv, nums[i]);
        }
        return res;
    }
}
