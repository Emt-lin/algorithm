package acwing.tree;

/**
 * @author psl
 * @date 2019/9/24
 *              46. 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则返回true，否则返回false。
 * 假设输入的数组的任意两个数字都互不相同
 * 样例
 * 输入：[4, 8, 6, 12, 16, 14, 10]
 * 输出：true
 *              解题思路：
 *                  二叉搜索树：先遍历左子树、再右子树，最后根节点。而且所有左子树的所有值小于根节点，右子树大于根节点
 *                  就是利用二叉搜索树的性质进行操作
 *              时间复杂度：O(n)
 */
public class VerifySequenceOfBST {
    int[] seq ;
    public boolean verifySequenceOfBST(int [] sequence) {
        seq = sequence;
        return dfs(0,sequence.length - 1);
    }

    public boolean dfs(int l, int r) {
        //如果左边大于右边，说明为空，直接返回true
        if (l >= r) return true;
        //得到根节点
        int root = seq[r];
        //从左边开始，找到第一个大于根节点的元素的位置
        int k = l;
        while (k < r && seq[k] < root){
            k++;
        }
        //看第一个开始大于根节点的元素后面的元素是否全部 >= 根节点
        for (int i = k; i < r; i++){
            //如果存在 < 根节点的元素，说明不是二叉搜索树
            if (seq[i] < root) return false;
        }
        //然后变分别对两边的元素进行递归遍历，看是否满足上面的规律
        return dfs(l, k - 1) && dfs(k, r -1 );
    }
}
