package acwing.array;

/**
 * @author psl
 * @date 2020/5/25
 *          69. 数组中数值和下标相等的元素
 *          解题思路：
 *              这道题可以利用一个新的数组：[nums[i] - i]，新数组满足单调递增的性质，
 *              只要找到这数组中为0的就可以了
 */
public class GetNumberSameAsIndex {
    public int getNumberSameAsIndex(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r){
            int mid = l + r >> 1;
            //说明当前数出现在其左边
            if (nums[mid] - mid >= 0) r = mid;
            else l = mid + 1;
        }
        if (nums[r] - r == 0) return r;
        else return -1;
    }
}
