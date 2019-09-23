package acwing.tree;

import java.util.*;

/**
 * @author psl
 * @date 2019/9/23
 *          45. 之字形打印二叉树
 * 请实现一个函数按照之字形顺序从上向下打印二叉树。
 * 即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 *          解题思路：
 *              采用宽度优先遍历
 *              用zigzag标志表明是从左往右遍历，还是从右往左遍历
 *          时间复杂度：
 */
public class printFromTopToBottom_Two {
    public List<List<Integer>> printFromTopToBottom(TreeNode_7 root) {
        //定义一个返回集合
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        //采用宽度遍历装元素的队列
        Queue<TreeNode_7> q = new LinkedList<>();
        q.add(root);
        //采用加入null，来标志本层元素已经遍历完
        q.add(null);

        //初始化一个装元素的集合
        List<Integer> level = new ArrayList<>();
        //为false表示从左往右遍历
        boolean zigzag = false;
        //队列不为空，就继续遍历
        while (q.size() != 0){
            //出队首元素
            TreeNode_7 t = q.poll();
            //如果出的队首元素为null，
            if (t == null){
                //并且如果level集合大小为0，说明整个树已经遍历完了，直接退出循环即可
                if (level.size() == 0) break;
                //否则说明当前层的所有节点已经遍历完，添加当前层所有元素到返回集合中
                //这里创建一个新的集合的原因：就是res这个集合的为一个集合元素 还是一直对 level集合保持引用关系
                //如果level改变，res集合里面的每一个都会对应改变。下面就是打印的res集合(不创建新的容器时)
                //为true，需要反转
                if (zigzag) Collections.reverse(level);
                List<Integer> tmp = new ArrayList<>(level);
                res.add(tmp);
                //并添加一个null标志
                q.add(null);
                //清除集合所有元素，为了下一层元素进入
                level.clear();
                //直接进入下一次循环，因为当前元素是null
                zigzag = !zigzag;
                continue;
            }
            //添加当前元素值进入集合
            level.add(t.val);
            if (t.left != null) q.add(t.left);
            if (t.right != null) q.add(t.right);
        }
        return res;
    }
}
class TreeNode_7 {
    int val;
    TreeNode_7 left;
    TreeNode_7 right;
    TreeNode_7(int x) { val = x; }
}