package myCode.tree;

/**
 * @author psl
 * @date 2020/7/10
 */
public class InOrderTraverse {
    public void inOrderTraverse(TreeNode root){
        if (root == null) return ;
        inOrderTraverse(root.left);
        System.out.println(root);
        inOrderTraverse(root.right);
    }

    public void inOrderTraverseDfs(TreeNode root){
        if (root == null) return ;
        inOrderTraverseDfs(root.left);
        System.out.println(root);
        inOrderTraverseDfs(root.right);
    }
}
