package acwing.tree;

/**
 * @author psl
 * @date 2019/9/9
 *              37. 树的子结构
 * 输入两棵二叉树A，B，判断B是不是A的子结构。
 * 我们规定空树不是任何树的子结构。
 *
 *          解题思路：
 *              用递归的思想
 *              1、遍历A树，先查找到与B树节点的值相同节点
 *              2、然后在匹配A树的子树 是否 和B树 相等
 *          时间复杂度：O(mn)
 *
 */
public class HasSubtree {
    public boolean hasSubtree(TreeNode_2 pRoot1, TreeNode_2 pRoot2) {
        if (pRoot1 == null || pRoot2 == null) return false;
        //先考虑根节点是否匹配
        if (isMatch(pRoot1,pRoot2)) return true;
        //然后分别左子树进行匹配，和 右子树进行匹配
        return hasSubtree(pRoot1.left,pRoot2) || hasSubtree(pRoot1.right,pRoot2);
    }

    public boolean isMatch(TreeNode_2 p1, TreeNode_2 p2) {
        //如果子树为空，说明匹配了
        if (p2 == null) return true;
        //如果父树为空了 或者 父树节点的值 不等于 子树节点的值，直接返回false
        if (p1 == null || p1.val != p2.val) return false;
        //然后就递归判断两颗树的左子树，和右子树是否相等
        return isMatch(p1.left,p2.left) && isMatch(p1.right,p2.right);
    }
}
 class TreeNode_2 {
     int val;
     TreeNode_2 left;
     TreeNode_2 right;
     TreeNode_2(int x) { val = x; }
 }