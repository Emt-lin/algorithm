package acwing.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author psl
 * @date 2019/9/23
 *          44. 分行从上往下打印二叉树
 * 从上到下按层打印二叉树，同一层的结点按从左到右的顺序打印，每一层打印到一行。
 *              解题思路：
 *                  就是采用广度优先遍历的思想。
 *                  同时，在每一层遍历完后面添加一个null作为标志，作为一层遍历完结束的标志
 *              时间复杂度：O(n)
 */
public class PrintFromTopToBottom_one {
    public List<List<Integer>> printFromTopToBottom(TreeNode_6 root) {
        //定义一个返回集合
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        //采用宽度遍历装元素的队列
        Queue<TreeNode_6> q = new LinkedList<>();
        q.add(root);
        //采用加入null，来标志本层元素已经遍历完
        q.add(null);

        //初始化一个装元素的集合
        List<Integer> level = new ArrayList<>();
        //队列不为空，就继续遍历
        while (q.size() != 0){
            //出队首元素
            TreeNode_6 t = q.poll();
            //如果出的队首元素为null，
            if (t == null){
                //并且如果level集合大小为0，说明整个树已经遍历完了，直接退出循环即可
                if (level.size() == 0) break;
                //否则说明当前层的所有节点已经遍历完，添加当前层所有元素到返回集合中
                //这里创建一个新的集合的原因：就是res这个集合的为一个集合元素 还是一直对 level集合保持引用关系
                //如果level改变，res集合里面的每一个都会对应改变。下面就是打印的res集合(不创建新的容器时)
                //[[8]]
                //[[12, 2], [12, 2]]
                //[[6], [6], [6]]
                //[[4], [4], [4], [4]]
                //[[], [], [], []]
                List<Integer> tmp = new ArrayList<>(level);
                res.add(tmp);
                //并添加一个null标志
                q.add(null);
                //清除集合所有元素，为了下一层元素进入
                level.clear();
                //直接进入下一次循环，因为当前元素是null
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

class TreeNode_6 {
    int val;
    TreeNode_6 left;
    TreeNode_6 right;
    TreeNode_6(int x) { val = x; }
}