package acwing.tree;

/**
 * @author psl
 * @date 2019/9/27
 *              49. 二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 注意：
 * 需要返回双向链表最左侧的节点。
 * 例如，输入下图中左边的二叉搜索树，则输出右边的排序双向链表。
 *              解题思路：
 *                  就是找到左边 最左和最右的两个节点，和 找到右边的最左和最右的节点
 *                  然后让左边的最右的节点的right指向根节点，右边的最左的节点的left指向根节点
 *                  然后让根节点的left指向左边的最右的节点，根节点的right指向右边的最左的节点
 *              时间复杂度：O(n)
 */
public class Convert {
    public TreeNode convert(TreeNode root) {
        //如果为空直接返回null
        if (root == null ) return null;
        Pair sides = dfs(root);
        return sides.first;
    }

     Pair dfs(TreeNode root) {
        //如果只存在根节点，那最左和最右都是根节点
        if (root.left == null && root.right == null) return new Pair(root,root);
        //如果左右子树都存在
        else if (root.left != null && root.right != null){
            Pair lsides = dfs(root.left),rsides = dfs(root.right);
            lsides.second.right = root;
            root.left = lsides.second;

            rsides.first.left = root;
            root.right = rsides.first;

            return new Pair(lsides.first,rsides.second);
        }
        //只存在左子树
        else if (root.left != null){
            Pair lsides = dfs(root.left);
            lsides.second.right = root;
            root.left = lsides.second;

            return new Pair(lsides.first,root);
        }
        //只存在右子树
        //  root.left != null
        else {
            Pair rsides = dfs(root.right);

            rsides.first.left = root;
            root.right = rsides.first;
            return new Pair(root,rsides.second);
        }
    }

    class Pair{
        TreeNode first;
        TreeNode second;
        Pair(TreeNode first,TreeNode second){
            this.first = first;
            this.second = second;
        }
    }
}
