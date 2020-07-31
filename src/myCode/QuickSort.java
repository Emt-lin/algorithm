package myCode;

import java.util.Arrays;

/**
 * @author psl
 * @date 2020/7/8
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {49, 38, 65, 97, 76, 13, 27, 49};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public static void quickSort(int[] nums, int low, int high){
        if (low < high){
            int pivotkey = Partition(nums, low, high);
            quickSort(nums, low, pivotkey - 1);
            quickSort(nums, pivotkey + 1, high);
        }
    }

    private static int Partition(int[] nums, int low, int high) {
        int pivotkey = nums[low];
        while (low < high){
            // 先从右边开始
            while (low < high && nums[high] >= pivotkey) --high;
            // 将右边小于枢轴记录移动到低端
            nums[low] = nums[high];
            // 然后再从左边开始
            while (low < high && nums[low] <= pivotkey) ++low;
            // 将左边大于枢轴记录移动到高端
            nums[high] = nums[low];
        }
        // 当low = high时，结束循环
        nums[low] = pivotkey;
        return low;
    }
}
