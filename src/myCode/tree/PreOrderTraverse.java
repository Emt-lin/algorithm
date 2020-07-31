package myCode.tree;

/**
 * @author psl
 * @date 2020/7/10
 */
public class PreOrderTraverse {
    public void preOrderTraverse(TreeNode root){
        if (root == null) return ;
        System.out.println(root);
        preOrderTraverseDfs(root.left);
        preOrderTraverseDfs(root.right);
    }
    // 递归实现
    public void preOrderTraverseDfs(TreeNode root){
        if (root == null) return ;
        System.out.println(root);
        preOrderTraverseDfs(root.left);
        preOrderTraverseDfs(root.right);
    }
}
