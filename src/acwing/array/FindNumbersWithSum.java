package acwing.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author psl
 * @date 2020/6/29
 *              75. 和为S的两个数字
 *              解题思路：
 *                  如果本题采用暴力求解，采用双循环，然后内循环看0到i-1是否有元素满足条件
 *
 */
public class FindNumbersWithSum {
    public int[] findNumbersWithSum(int[] nums, int target) {
        Set<Integer> hash =  new HashSet<>();
        for (int i = 0; i < nums.length; i ++){
            // 查看前i-1个元素里是否有符合的元素
            // 如果当前hash里面包含了 target - nums[i])，直接返回就行
            if (hash.contains(target - nums[i])) return new int[]{target - nums[i], nums[i]};
            // 使用hash存储0到 i - 1的元素
            hash.add(nums[i]);
        }
        return nums;
    }
}
