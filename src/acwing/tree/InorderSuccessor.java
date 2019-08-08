package acwing.tree;

/**
 * @author psl
 * @date 2019/8/7
 *          二叉树的下一个节点
 * 给定一棵二叉树的其中一个节点，请找出中序遍历序列的下一个节点
 * 注意：
 *
 * 如果给定的节点是中序遍历序列的最后一个，则返回空节点;
 * 二叉树一定不为空，且给定的节点一定不是空节点；
 * 样例
 * 假定二叉树是：[2, 1, 3, null, null, null, null]， 给出的是值等于2的节点。
 *
 * 则应返回值等于3的节点。
 *
 * 解释：该二叉树的结构如下，2的后继节点是3。
 *   2
 *  / \
 * 1   3
 *              解题思路：
 *         分成2种情况：
 *              1、当p有右子树时，右子树最左边的节点便是该节点中序遍历的下一个节点
 *              2、当p没有右子树时：
 *                      1、如果p节点属于某个父节点节点的左子树，那么返回该父节点
 *                      2、如果不是属于某个父节点的左子树，那么就没有中序遍历的下个节点，返回null
 *          时间复杂度：O(h)
 *              无论是向下找，还是向上找都不会超过树的高度
 */
public class InorderSuccessor {
    public TreeNode_1 inorderSuccessor(TreeNode_1 p) {
        //如果p有右子树，那么右子树最左边的节点便是中序遍历的下一个节点
        if (p.right != null){
            p = p.left;
            while (p.left != null) p = p.left;
            return p;
        }
        //如果p没有右子树，那么就找父节点，如果p节点属于某个父节点节点的左子树，那么返回该父节点
        //如果不是属于某个父节点的左子树，那么就没有中序遍历的下个节点，返回null
        while (p.father != null && p == p.father.right) p = p.father;
        return p.father;
    }
}
class TreeNode_1 {
     int val;
    TreeNode_1 left;
    TreeNode_1 right;
    TreeNode_1 father;
     TreeNode_1(int x) { val = x; }
 }