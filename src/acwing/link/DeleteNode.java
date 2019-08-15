package acwing.link;

/**
 * @author psl
 * @date 2019/8/15
 *          28. 在O(1)时间删除链表结点
 * 给定单向链表的一个节点指针，定义一个函数在O(1)时间删除该结点。
 * 假设链表一定存在，并且该节点一定不是尾节点。
 * 样例
 * 输入：链表 1->4->6->8
 * 删掉节点：第2个节点即6（头节点为第0个节点）    输出：新链表 1->4->8
 *         解题思路：
 *          就是把要删的那个节点的值赋值为这个节点下一个节点的值，然后删除这个节点的下一个节点
 *      哈哈哈哈哈哈哈！！！！
 *      时间复杂度：O(1)
 */
public class DeleteNode {
    public void deleteNode(_ListNode node){
        //第一种解法
        node.val = node.next.val;
        node.next = node.next.next;
        //第二种：c++,运用了 解引用 的知识
        // *node = *(node->next);
    }
}
class _ListNode {
        int val;
     _ListNode next;
     _ListNode(int x) { val = x; }
}