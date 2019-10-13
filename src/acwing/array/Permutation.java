package acwing.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author psl
 * @date 2019/10/9
 *          51. 数字排列
 * 输入一组数字（可能包含重复数字），输出其所有的排列方式。
 * 样例
 * 输入：[1,2,3]
 * 输出：
 *       [
 *         [1,2,3],
 *         [1,3,2],
 *         [2,1,3],
 *         [2,3,1],
 *         [3,1,2],
 *         [3,2,1]
 *       ]
 *                  解题思路：
 *                      先排序，然后进递归遍历数组，进行操作
 *                      亮点：采用2进制来表示位置是否被使用
 *                  时间复杂度：
 */
public class Permutation {
    List<List<Integer>> ans = new ArrayList<>();
    Integer[] path;
    public List<List<Integer>> permutation(int[] nums) {
        path = new Integer[nums.length];
        Arrays.sort(nums);
        //这里state，采用二进制位来表示哪个位置是否被使用，eg：010——>表示第二位被占用
        dfs(nums, 0, 0, 0);
        return ans;
    }

    private void dfs(int[] nums, int u, int start, int state) {
        if (u == nums.length){
            //由于path是全局变量，不要重复用指向同一个地址的引用。否则最终结果会全部一样
            ans.add(new ArrayList<>(Arrays.asList(path)));
            return;
        }
        //如果u为0，或者前一位和当前位不同，就从0开始
        if(u == 0 || nums[u] != nums[u - 1]) start = 0;
        for(int i = start; i < nums.length; i++){
            //这里使用state右移i位 再与 1相与，来表示第 i 位是否被使用。为0表示未使用
            if ((state >> i & 1) == 0){
                path[i] = nums[u];
                //递归，这里巧妙的地方：   state + (1 << i)，就是第i个位置被用的话，就让1左移i位就行
                dfs(nums, u +1, i + 1, state + (1 << i));
            }
        }
    }
}
