package acwing.array;

/**
 * @author psl
 * @date 2019/8/2
 *         题目： 找出数组中重复的数字
 * 给定一个长度为 n 的整数数组 nums，数组中所有的数字都在 0∼n−1 的范围内。
 *
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 *
 * 请找出数组中任意一个重复的数字。
 * 注意：如果某些数字不在 0∼n−1 的范围内，或数组中不包含重复数字，则返回 -1；
 * 样例
 * 给定 nums = [2, 3, 5, 4, 3, 2, 6, 7]。
 * 返回 2 或 3。
 *
 * 解题思路：
 *      就是让数组中的值移动到与值相等的数组下标处，如果
 */

public class DuplicateInArray {
    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 4, 3, 2, 6, 7};
        System.out.println(duplicateInArray(nums));
    }
    public static int duplicateInArray(int[] nums) {
        int len = nums.length;
        int temp = 0;
        //如果不在0~n-1，返回-1
        for(int num : nums){
            if (num < 0 || num > len -1 )
                return -1;
        }
        for(int i = 0;i < len; i++){
            //首先当前数组下标为i的值不等于当前数组下标i 并且 当前数组下标为i的值不等于位于当前数组下标i的值为数组下标的值，然后交换
            while (i != nums[i] && nums[i] != nums[nums[i]]){
                temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[temp] = temp;
            }
            //如果当前数组下标为i的值不等于当前数组下标i 并且 当前数组下标为i的值等于位于当前数组下标i的值为数组下标的值，然后就出现重复
            //就是当前的值没有在当前值得数组下标处
            if (nums[i] != i && nums[i] == nums[nums[i]])
                return nums[i];
        }

        return -1;
    }
}
