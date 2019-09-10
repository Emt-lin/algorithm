package acwing.tree;

/**
 * @author psl
 * @date 2019/9/10
 *          38. 二叉树的镜像
 *  输入一个二叉树，将它变换为它的镜像。
 *              解题思路：
 *                  就是树的节点的左右儿子互换
 *              时间复杂度：O(n)
 */
public class Mirror {
    public void mirror(TreeNode_3 root) {
        if (root == null ) return;
        mirror(root.left);
        mirror(root.right);
        TreeNode_3 tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }
}
class TreeNode_3 {
     int val;
    TreeNode_3 left;
    TreeNode_3 right;
    TreeNode_3(int x) { val = x; }
 }
