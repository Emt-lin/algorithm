package acwing;

/**
 * @author psl
 * @date 2019/8/4
 * 定一个长度为 n+1 的数组nums，数组中所有的数均在 1∼n 的范围内，其中 n≥1。
 *
 * 请找出数组中任意一个重复的数，但不能修改输入的数组。
 *      样例
 * 给定 nums = [2, 3, 5, 4, 3, 2, 6, 7]。
 *
 * 返回 2 或 3。
 * 思考题：如果只能使用 O(1) 的额外空间，该怎么做呢？
 *
 *      解题思想：
 *          本题用到了抽屉原理。抽屉原理：n+1 个苹果放在 n 个抽屉里，那么至少有一个抽屉中会放两个苹果。
 *          由于本题数组长度为n+1，值在1~n，所以必有一个重复。把值分成2个区间，用2分法。
 *          分别统计在2个区间的个数，那一边数比坑多，那重复的数一定在那边
 *          时间复杂度：O(nlogn)
 *          空间复杂度：O(1)
 */
public class DuplicateInArray_1 {
    public static void main(String[] args) {
            int[] nums = {2, 3, 5, 4, 3, 2, 6, 7};
             System.out.println(duplicateInArray(nums));
    }
    public static int duplicateInArray(int[] nums) {
        int l = 1,r = nums.length - 1;
        while (l < r){
            //除以2
            int  mid = l + r >> 1;
            int s = 0;
            //统计在左边区间的个数
            for (int num : nums){
                if (num >= l && num <= mid){
                    s++;
                }
            }
            //如果个数大于mid，说明重复的数在左边，反之亦然
            if (s > mid - l + 1) r = mid;
            else l = mid + 1;
        }
        return r;
    }
}
