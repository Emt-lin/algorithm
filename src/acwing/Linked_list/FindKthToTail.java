package acwing.Linked_list;

/**
 * @author psl
 * @date 2019/9/6
 *              	33.链表中倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 注意：
 * k >= 0;
 * 如果k大于链表长度，则返回 NULL;
 * 样例
 * 输入：链表：1->2->3->4->5 ，k=2
 * 输出：4
 *              解题思路：
 *              1、先得到链表的长度n
 *              2、倒数第k个节点，就相当于正数第 n-k+1 个节点
 *              时间复杂度：O(n)
 *
 */
public class FindKthToTail {
    public ListNode_2 findKthToTail(ListNode_2 head, int k) {
        int n = 0;
        //计算出链表的长度
        for (ListNode_2 p = head; p != null ;p = p.next) n++;
        if (k > n) return null;
        ListNode_2 p = head;
        //倒数第k个节点，就相当于正数第 n-k+1 个节点
        for (int i = 0; i < n - k; i++) p = p.next;
        return p;
    }
}
 class ListNode_2 {
        int val;
        ListNode_2 next;
        ListNode_2(int x) { val = x; }
 }