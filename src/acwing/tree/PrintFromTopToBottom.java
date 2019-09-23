package acwing.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author psl
 * @date 2019/9/23
 *          43. 不分行从上往下打印二叉树
 * 从上往下打印出二叉树的每个结点，同一层的结点按照从左到右的顺序打印。
 *
 *          解题思路：
 *              就是一个简单的广度优先遍历
 *          时间复杂度：O(n)
 */
public class PrintFromTopToBottom {
    public List<Integer> printFromTopToBottom(TreeNode_5 root) {
        LinkedList<Integer> res = new LinkedList<>();
        Queue<TreeNode_5> q = new LinkedList<>();
        if (root == null) return res;
        q.add(root);
        while (q.size() != 0){
            TreeNode_5 t = q.poll();
            res.addLast(t.val);
            if (t.left != null) q.add(t.left);
            if (t.right != null) q.add(t.right);
        }
        return res;
    }
}
class TreeNode_5 {
    int val;
    TreeNode_5 left;
    TreeNode_5 right;
    TreeNode_5(int x) { val = x; }
 }
