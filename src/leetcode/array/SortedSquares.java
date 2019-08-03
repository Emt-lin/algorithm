package leetcode.array;

import java.util.Arrays;

/**
 * @author psl
 * @date 2019/6/28
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 *
 * 解题思路：
 *  主要用双指针法，非负已经是升序，负数平方是降序，所以找到原数组非负那个点，然后负数反向遍历，非负正向遍历，进行比较
 */
public class SortedSquares {
    public static void main(String[] args) {
        int[] a = {-4,-1,0,3,10};
        int[] ans = sortedSquares(a);
        System.out.println(Arrays.toString(ans));;
    }
    public static int[] sortedSquares(int[] A) {
        int length = A.length;
        //找到原数组非负那个点
        int pos = 0;
        int[] ans = new int[length];
        while (pos < length && A[pos] < 0){
            pos++;
        }
        int i = pos - 1;
        int t = 0;
        //然后负数反向遍历，非负正向遍历，进行比较
        while (i >= 0 && pos < length){
            if (A[i] * A[i] < A[pos] * A[pos]){
                ans[t++] = A[i] * A[i];
                i--;
            }else {
                ans[t++] = A[pos] * A[pos];
                pos++;
            }
        }
        while (i >= 0){
            ans[t++] = A[i] * A[i];
            i--;
        }
        while (pos < length){
            ans[t++] = A[pos] * A[pos];
            pos++;
        }
        return ans;
    }
}
