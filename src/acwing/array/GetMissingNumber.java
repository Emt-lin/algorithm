package acwing.array;

/**
 * @author psl
 * @date 2020/5/25
 *          68. 0到n-1中缺失的数字
 *          解题思路：O(logn)
 *              采用二分的思想：如果nums[mid] != mid，说明缺失的数就在 mid或者mid的左边
 */
public class GetMissingNumber {
    public int getMissingNumber(int[] nums) {
        if (nums.length == 0) return 0;
        int l = 0, r = nums.length - 1;
        while (l < r){
            int mid = l + r >> 1;
            if (nums[mid] != mid) r = mid;
            else l = mid + 1;
        }
        //特殊情况，当所有数都满足nums[mid] == mid,说明缺少的是n
        if (nums[r] == r) r++;
        return r;
    }
}
