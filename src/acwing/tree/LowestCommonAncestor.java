package acwing.tree;

/**
 * @author psl
 * @date 2020/7/3
 *          88. 树中两个结点的最低公共祖先
 *          解题思路：O(n)
 *              分为两种情况：
 *              1、要么两者在一个节点的两边
 *              2、要么一个是另一个的子节点
 *              采用后序遍历
 *
 *
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 走到空节点就直接返回
        if(root == null) return null;
        // 这个条件是，如果q（p）在p（q）的子树上 或者 p（q）没在q（p）子树上，都需要将这个找到的p（q）返回
        if (root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 这个是递归回溯时，回溯到某个节点时，两者都不为空的话，这就是最低公共祖先
        if (left != null && right != null) return root;
        // 只要left不为空，就相当于找到了p或q在对应的子树上，需要返回，以便于回溯使用
        if (left != null) return left;
        // 否则，不管right 是否等于空，都直接返回right
        else return right;
    }
}
