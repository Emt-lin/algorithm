package acwing.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author psl
 * @date 2020/5/18
 *          65. 数组中的逆序对
 *          解题思路：O(nlog^n)
 *              本题利用了归并排序的思想
 *              所有的逆序对 = 左边的 + 右边的 + 左边和右边
 */
public class InversePairs {
    public int merge(int[] nums, int l, int r){
        //代表只有一个数
        if (l >= r) return 0;
        int mid = l + r >> 1;
        //1、这是左边 、右边的逆序对
        int res = merge(nums, l, mid) + merge(nums, mid + 1, r);
        int i = l, j = mid + 1;
        //存放中间结果
        List<Integer> temp = new ArrayList<>();
        while (i <= mid  && j <= r){

            if (nums[i] <= nums[j]) temp.add(nums[i ++]);
            //当左边的大于右边的时候，左边 i 到 mid都是j的逆序对
            else {
                temp.add(nums[j ++]);
                //2、这是左边比右边数大的逆序对
                res += mid - i + 1;
            }
        }
        //可能i还没到mid
        while (i <= mid)  temp.add(nums[i ++]);
        //可能j还没到r
        while (j <= r)  temp.add(nums[j ++]);
        //把排好序的结果放回nums数组，为上一层做准备
        i = l;
        for (int x : temp) nums[i ++] = x;
        return res;
    }
    public int inversePairs(int[] nums) {
        return merge(nums, 0, nums.length - 1);
    }
}
