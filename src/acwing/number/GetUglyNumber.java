package acwing.number;

import java.util.ArrayList;
import java.util.List;

/**
 * @author psl
 * @date 2020/5/17
 *          62. 丑数
 * 我们把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 求第n个丑数的值。
 * 样例 输入：5 输出：5
 * 注意：习惯上我们把1当做第一个丑数。
 *          解题思路：
 *              这道题相当于类似于三路归并
 *                  含有因子 2的一个数组、含有因子 3的一个数组、含有因子 5的一个数组，然后每次取3个中最小的
 *              i：代表 2 ，同时它的值代表位置
 */
public class GetUglyNumber {
    public int getUglyNumber(int n) {
        List<Integer> q = new ArrayList<>();
        q.add(1);
        int i = 0, j = 0, k = 0;
        while (-- n != 0){
            int t = Math.min(q.get(i) * 2, Math.min(q.get(j) * 3, q.get(k) * 5));
            q.add(t);
            // 把相同的都要移位
            if (q.get(i) * 2 == t) i ++;
            if (q.get(j) * 3 == t) j ++;
            if (q.get(k) * 5 == t) k ++;
        }
        return q.get(q.size() - 1);
    }
}
