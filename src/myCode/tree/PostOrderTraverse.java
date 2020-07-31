package myCode.tree;


/**
 * @author psl
 * @date 2020/7/10
 */
public class PostOrderTraverse {
    public void postOrderTraverse(TreeNode root){
        if (root == null) return ;
        postOrderTraverse(root.left);
        postOrderTraverse(root.right);
        System.out.println(root);
    }
}
