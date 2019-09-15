package acwing.tree;

/**
 * @author psl
 * @date 2019/9/15
 *              39. 对称的二叉树
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。
 * 如果一棵二叉树和它的镜像一样，那么它是对称的。
 *          解题思路：
 *              采用递归
 *              互为镜像：
 *                  1、两棵子树的根节点值相等
 *                  2、第一棵子树的左儿子和第二棵子树的右儿子相等 并且 第一棵子树的右儿子和第二棵子树的左儿子相等
 *          时间复杂度：O(n)
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode_4 root) {
        if (root == null) return true;
        return dfs(root.left,root.right);
    }

    public boolean dfs(TreeNode_4 p, TreeNode_4 q) {
        if (p == null || q == null) return p == null && q == null;
        if (p.val != q.val) return false;
        return dfs(p.left,q.right) && dfs(p.right, q.left);
    }
}
class TreeNode_4 {
     int val;
    TreeNode_4 left;
    TreeNode_4 right;
    TreeNode_4(int x) { val = x; }
 }