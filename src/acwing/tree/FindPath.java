package acwing.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author psl
 * @date 2019/9/25
 *              47. 二叉树中和为某一值的路径
 * 输入一棵二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。=
 * 样例
 * 给出二叉树如下所示，并给出num=22。
 *       5
 *      / \
 *     4   6
 *    /   / \
 *   12  13  6
 *  /  \    / \
 * 9    1  5   1
 * 输出：[[5,4,12,1],[5,6,6,5]]
 *              解题思路：
 *                  采用深度优先遍历
 *              时间复杂度：O()
 */
public class FindPath {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> findPath(TreeNode_8 root, int sum) {
        dfs(root,sum);
        return ans;
    }

    public void dfs(TreeNode_8 root, int sum) {
        if (root == null) return;
        path.add(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0)
            //这里要注意引用的问题
            ans.add(new ArrayList<>(path));
        dfs(root.left, sum);
        dfs(root.right, sum );
        //递归往回走一次移走一个，因为还可能遍历其他分支，找到对应符合结果的
        path.remove(path.size() - 1);
    }
}
class TreeNode_8 {
    int val;
    TreeNode_8 left;
    TreeNode_8 right;

    TreeNode_8(int x) {
        val = x;
    }
}