package acwing.tree;

/**
 * @author psl
 * @date 2020/6/28
 *          72. 平衡二叉树
 *          解题思路：
 *
 *
 */
public class IsBalanced {
    boolean ans = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        // 当前节点左子树的高度
        int left = dfs(root.left);
        // 当前节点右子树的高度
        int right = dfs(root.right);
        // 如果左右子树相差大于1，就代表不是平衡二叉树
        if (Math.abs(left - right) > 1) ans = false;
        // 计算一个节点的左子树或右子树的高度
        // 返回当前左右子树的高度中的最大值，便于递归上一层左右子树的比较
        return Math.max(left, right) + 1;
    }
}
