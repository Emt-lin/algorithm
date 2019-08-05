package acwing.array;

import java.lang.reflect.Array;

/**
 * @author psl
 * @date 2019/8/5
 *           二维数组中的查找
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 *
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *  样例
 * 输入数组：
 * [
 *   [1,2,8,9]，
 *   [2,4,9,12]，
 *   [4,7,10,13]，
 *   [6,8,11,15]
 * ]
 * 如果输入查找数值为7，则返回true，
 * 如果输入查找数值为5，则返回false。
 *      解题思路：
 *          (单调性扫描)由于此题行和列都是按从小到大的排列，所以可以用类似二分的方法解决
 *    从最右上角开始
 *      当target大于这个值时，就可以排除当前行所有值，让i++；
 *      当target小于这个值时，就可以排除当前列所有值，让j++；
 *    时间复杂度：
 *      由于每次都排除一行或者一列，所以复杂度为O(n+m)
 */
public class SearchArray {
    public static void main(String[] args) {
        int[][] nums = {
                            {1,2,8,9},
                            {2,4,9,12},
                            {4,7,10,13},
                            {6,8,11,15}
                        };
        System.out.println(searchArray(nums,20));
    }
    public static boolean searchArray(int[][] array, int target) {
        //判断数组是否为空，为空直接返回false
        if (array.length == 0 || array[0].length == 0) return false;
        int i = 0,j = array[0].length - 1;
        // i小于数组的行下标，j小于数组的列下标
        while (i < array.length && j >= 0){
            if (array[i][j] == target) return true;
            //target小于当前坐标值，j--
            else if (array[i][j] > target) j--;
            //target大于当前坐标值，i++
            else i++;
        }
        return false;
    }
}
