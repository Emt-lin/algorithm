package acwing.tree;

/**
 * @author psl
 * @date 2020/6/28
 *          70. 二叉搜索树的第k个结点
 *          解题思路：
 *              直接使用中序遍历找第k小的值（中序遍历的结果是要从小到大排的）
 *
 */
public class KthNode {
    TreeNode ans;
    // 全局变量来同步值
    int k1;
    public TreeNode kthNode(TreeNode root, int k) {
        k1 = k;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        k1--;
        //当k为0时，就是所求结果
        if (k1 == 0) ans = root;
        //只有当k大于0时，才需要进行右递归（其实也可以上面直接返回了，当k为0时）
        if(k1 > 0) dfs(root.right);
    }
}
