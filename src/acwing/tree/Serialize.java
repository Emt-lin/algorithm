package acwing.tree;

/**
 * @author psl
 * @date 2019/9/29
 *          50. 序列化二叉树
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 * 您需要确保二叉树可以序列化为字符串，并且可以将此字符串反序列化为原始树结构。
 * 样例
 * 你可以序列化如下的二叉树
 *     8
 *    / \
 *   12  2
 *      / \
 *     6   4
 * 为："[8, 12, 2, null, null, 6, 4, null, null, null, null]"
 * 注意:
 * 以上的格式是AcWing序列化二叉树的方式，你不必一定按照此格式，所以可以设计出一些新的构造方式。
 *                  解题思路：
 *                      有个解题技巧：就是一个数字字符串：
 *                          data = "123" ——>当val=0,循环val = val * 10 + data[index] - '0'
 *                          这样得到 val = 123
 *                  时间复杂度：
 */
public class Serialize {
    String res = "";
    // Encodes a tree to a single string.
    String serialize(TreeNode root) {
        //用的前序遍历
        dfs_s(root);
        return res;
    }
    void dfs_s(TreeNode root) {
        if (root == null) {
            res += "null ";
            return;
        }
        res += root.val + ' ';
        dfs_s(root.left);
        dfs_s(root.right);
    }
    // Decodes your encoded data to tree.
    int u = 0;
    TreeNode deserialize(String data) {
        return dfs_d(data);
    }

    public TreeNode dfs_d(String data) {

        if (u == data.length()) return null;
        int k = u;
        //如果当前字符的值不为空格，k就向前遍历
        while(data.charAt(k) != ' ') k ++ ;
        //如果传入的u当前索引位置的字符为n，说明直接为null,然后直接把 u = k + 1
        if (data.charAt(u) == 'n'){
            u = k + 1;
            return null;
        }
        int val = 0;
        //定义一个是否为负数的标志
        boolean is_minus = false;
        //遍历 [u ——> k-1] 这个区间的数字，这里的val用了一个巧妙的东西
        for (int i = u; i < k; k++ ) {
            if (data.charAt(i) == '-')
                is_minus = true;
            else
                val = val * 10 + data.charAt(i) - '0';

        }
        u = k + 1;
        if (is_minus) val = -val;
        TreeNode root = new TreeNode(val);
        //然后依次向左，向右进行递归添加节点
        root.left = dfs_d(data);
        root.right = dfs_d(data);
        return root;
    }
}
