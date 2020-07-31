package myCode.tree;

/**
 * @author psl
 * @date 2020/7/10
 */
public class TreeNode {
    public String content;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(String content, TreeNode left, TreeNode right) {
        this.content = content;
        this.left = left;
        this.right = right;
    }
}
