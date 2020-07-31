package acwing.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author psl
 * @date 2020/6/29
 *              80. 骰子的点数
 *              解题思路：
 *                  热狗法
 *
 *                  1、状态 f[i, j] 表示：前i次，总和为j的方案数
 *                  2、如何计算      按照最后一次的点数划分集合（1-6）
 *                  3、边界问题
 *
 *                  DP也是，考虑状态表示和状态计算，和最后的边界情况。
 *                  f[i][j]表示——前i次掷色子，总和是j的方案数。
 *                  边界就是最后一次的情况，分6类，不同的类对应不同的结果。
 *
 */
public class NumberOfDice {
    // 方法一：dp
    public int[] numberOfDice(int n) {
        // 用最后一行代表最终求的结果
        int[][] f = new int[n + 1][6 * n + 1];
        // 初始状态就f[0][0] = 1
        f[0][0] = 1;
        //
        for (int i = 1; i <= n; i ++)
            // 当投掷次数为i时，投掷出的结果可能有 1 到 6 * i
            for (int j = 1; j <= 6 * i; j ++)
                // 这代表当投掷次数为i时，最后一次投掷的点数。k <= Math.min(j, 6)，因为总和存在可能小于6
                for (int k = 1; k <= Math.min(j, 6); k ++)
                    // 前i次，总和为j的方案数 = 当前第i次（为k） + 加上前i-1次的结果
                    f[i][j] += f[i - 1][j - k];

         List<Integer> temp = new ArrayList<>();
         // 代表前n次，总和为i的所有元素就是所求结果
         for (int i = n; i <= 6 * n; i ++) temp.add(f[n][i]);
         int[] res = new int[temp.size()];
         int i = 0;
         for (int t : temp){
             res[i] = t;
             i ++;
         }
         return res;
    }
    // 方法二：暴力枚举（dfs）
/*    public int[] numberOfDice(int n) {
        int[] res;
        List<Integer> temp = new ArrayList<>();
        for (int i = n; i <= 6 * n; i ++) temp.add(dfs(n, i));
        res = new int[temp.size()];
        int i = 0;
        for (int t : temp){
            res[i] = t;
            i ++;
        }
        return res;
    }
    // 总和是sum和次数是n的情况下，返回共有多少种组合
    public int dfs(int n, int sum) {
        //
        if (n == 0 && sum == 0) return 1;
        if (sum < 0 || n == 0) return 0;
        int res = 0;
        // 这是考虑当第n次是i，考虑递归考虑前 n - 1次
        for (int i = 1; i <=  6; i ++){
            res += dfs(n - 1, sum - i);
        }
        return res;
    }*/
}
