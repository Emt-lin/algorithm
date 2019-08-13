package acwing;

/**
 * @author psl
 * @date 2019/8/13
 *              25. 剪绳子
 * 给你一根长度为 n 绳子，请把绳子剪成 m 段（m、n 都是整数，2≤n≤58 并且 m≥2）。
 * 每段的绳子的长度记为k[0]、k[1]、……、k[m]。k[0]k[1] … k[m] 可能的最大乘积是多少？
 * 例如当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到最大的乘积18。
 *  样例
 *  输入：8        输出：18
 *          解题思路：
 *          N > 0 N = n1 + n2 + n3 +....+nk
 *      1、假设ni >= 5 把ni分成 3 * (ni - 3) >= ni ?  =>  2ni >= 9
 *      2、假设ni = 4  ni = 2 * 2
 *      3、2 * 2 * 2 < 3 * 3 => 就是最多有两个2，3个2就直接分成两个3了
 *      4、肯定不能有1
 *          综上，选用尽量多的3，直到剩下2或者4时，用2。
 *          时间复杂度：
 *              当n很大时，n被分成（n/3）个数，然后做这么多次的乘除法，所以复杂度为：O(n)
 */
public class MaxProductAfterCutting {
    public int maxProductAfterCutting(int length){
        //题目要求最低2段
        if(length <= 3) return 1 * (length - 1 );
        int res = 1;
        //如果长度模3等于1，说明要拿一个3和1组成4分成2和2，然后长度减4
        if (length % 3 == 1) {
            res *= 4;
            length -= 4;
        }
        //如果长度模3等于2，那直接长度间减2
        if (length % 3 == 2){
            res *= 2;
            length -= 2;
        }
        //循环，求出最大乘积
        while (length > 0){
            res *= 3;
            length -= 3;
        }
        return res;
    }
}
