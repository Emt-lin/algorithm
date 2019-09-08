package acwing.Linked_list;

/**
 * @author psl
 * @date 2019/9/8
 *          35. 反转链表
 * 定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。
 * 样例
 * 输入:1->2->3->4->5->NULL
 * 输出:5->4->3->2->1->NULL
 *             解题思路：
 *             采用双指针法。
 *
 *             时间复杂度：O(n)
 *
 */
public class ReverseList {
    public ListNode_4 reverseList(ListNode_4 head) {
        ListNode_4 pre = null;
        ListNode_4 cur = head;
        while(cur != null){
            ListNode_4 next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
 class ListNode_4 {
     int val;
     ListNode_4 next;
     ListNode_4(int x) { val = x; }
 }