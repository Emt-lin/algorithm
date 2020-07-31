package acwing.array;

/**
 * @author psl
 * @date 2020/5/18
 *          67. 数字在排序数组中出现的次数
 *          解题思路：
 *              本题利用二分的方法
 *              找出这个数段的上边界和下边界就能计算出个数
 */
public class GetNumberOfK {
    public int getNumberOfK(int[] nums, int k) {
        if(nums.length == 0 ) return 0;
        int l = 0, r = nums.length - 1;
        //找上边界，条件是：只要nums[mid] >= k
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= k) r = mid;
            else l = mid + 1;
        }
        int left = l;
        System.out.println(left);
        l = 0;
        r = nums.length - 1;
        //找下边界,条件是：只要nums[mid] <= k
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] <= k) l = mid;
            else r = mid - 1;
        }
        if(nums[left] != k || nums[l] != k) return 0;
        System.out.println(l);
        return l - left + 1;
    }
}
