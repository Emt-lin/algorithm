package acwing.array;

import java.util.Arrays;

/**
 * @author psl
 * @date 2019/9/6
 *      	32.调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序。
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分。
 *  样例
 * 输入：[1,2,3,4,5]
 * 输出: [1,3,5,2,4]
 *          解题思想：
 *           用双指针法，一个指在头，一个指在尾。类似于快排的思想
 *          时间复杂度：O(n)
 */
public class ReOrderArray {
    public void reOrderArray(int [] array) {
        int l = 0, r = array.length - 1;
        while (l < r){
            while (l < r && array[l] % 2 == 1) l++;
            while (l < r && array[r] % 2 == 0) r--;
            if (l < r) {
                int temp = array[l];
                array[l] = array[r];
                array[r] = temp;
            }
        }
    }
}
