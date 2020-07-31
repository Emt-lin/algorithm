package acwing.tree;

/**
 * @author psl
 * @date 2020/6/28
 *          71. 二叉树的深度
 *          解题思路：
 *              最大深度 = 左右子树中最大深度 + 1（1是代表根节点）
 *
 */
public class TreeDepth {
    public int treeDepth(TreeNode root) {
        //不存在时，直接返回0
        if (root == null) return 0;
        return Math.max(treeDepth(root.left), treeDepth(root.right)) + 1;
    }
}
