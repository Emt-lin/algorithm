package acwing.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author psl
 * @date 2019/8/6
 *      重建二叉树
 * 输入一棵二叉树前序遍历和中序遍历的结果，请重建该二叉树。
 *
 * 注意:
 *
 * 二叉树中每个节点的值都互不相同；
 * 输入的前序遍历和中序遍历一定合法；
 *
 * 样例
 * 给定：
 * 前序遍历是：[3, 9, 20, 15, 7]
 * 中序遍历是：[9, 3, 15, 20, 7]
 *
 * 返回：[3, 9, 20, null, null, 15, 7, null, null, null, null]
 * 返回的二叉树如下所示：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *          解题思路：
 *      利用递归遍历的思想，然后为了快速确定中序遍历中根节点的位置，用hash表来确定
 *      时间复杂度：O(n)
 */
public class ReBuildTree {
    //装中序遍历的hash表
     Map<Integer,Integer> hash = new HashMap<>();
     //声明2个全局变量，以便后面使用
     int[] preorder,inorder;
    public  TreeNode buildTree(int[] _preorder, int[] _inorder) {
        preorder = _preorder;
        inorder = _inorder;
        //将值装入hash表
        for (int i = 0;i < _inorder.length;i++) hash.put(_inorder[i],i);
        //采用递归思想
        return dfs(0,preorder.length - 1,0,inorder.length - 1);
}
    public  TreeNode dfs(int pl,int pr,int il,int ir){
        //如果前序遍历数组中，左边的值已经大于数组长度，就返回null
        if (pl > pr) return null;
        //根节点
        TreeNode root = new TreeNode(preorder[pl]);
        //得到在中序遍历数组中当前根节点的位置
        int k = hash.get(root.val);
        //四个值：前序数组中左子树根节点后的第一个值、前序数组左子树的长度、
        // 中序数组左子树第一个值、中序数组左子树当前根节点左边的值
        TreeNode left = dfs(pl + 1,pl + 1 + k - il - 1,il, k - 1);
        //四个值：前序数组中右子树根节点后的第一个值、前序数组右子树的长度、
        // 中序数组右子树第一个值、中序数组右子树当前根节点左边的值
        TreeNode right = dfs(pl + 1 + k - il,pr,k + 1,ir);
        root.left = left;
        root.right = right;
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

