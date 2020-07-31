package acwing;

import java.util.ArrayList;
import java.util.List;

/**
 * @author psl
 * @date 2020/6/29
 *          76. 和为S的连续正数序列
 *          解题思路：O(n)
 *              采用双指针
 *
 */
public class FindContinuousSequence {
    public List<List<Integer>> findContinuousSequence(int sum) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1, j = 1, s = 1; i <= sum; i ++){
            // 由于i和j的移动符合单调性，所以采用双指针来移动
            while (s < sum) s += ++ j;
            // s == sum 且 i和j区间长度要大于1
            if (s == sum && j - i + 1 > 1){
                List<Integer> line = new ArrayList<>();
                // 将符合条件的值进行添加
                for (int k = i; k <= j; k++) line.add(k);
                res.add(line);
            }
            // 这个代表i向后移动
            s  -= i;
        }
        return res;
        // 方法二：暴力解法
//        int end = (sum + 1 ) >> 1;
//        for (int i = 1; i < end; i ++){
//            for (int j = i + 1; j <= end; j ++){
//                if ((j - i + 1) * (j + i) >> 1 == sum) {
//                    List<Integer> line = new ArrayList<>();
//                    for (int k = i; k <= j; k++) line.add(k);
//                    res.add(line);
//                    break;
//                }
//            }
//        }
    }
}
