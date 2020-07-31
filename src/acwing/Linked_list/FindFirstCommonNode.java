package acwing.Linked_list;

/**
 * @author psl
 * @date 2020/5/18
 *          66. 两个链表的第一个公共结点
 */
public class FindFirstCommonNode {
    public ListNode_7 findFirstCommonNode(ListNode_7 headA, ListNode_7 headB) {
        ListNode_7 p = headA, q = headB;
        while (p != q){
            if (p != null) p = p.next;
            else p = headB;
            if (q != null) q = q.next;
            else q = headA;
        }
        return p;
    }
}

 class ListNode_7 {
    int val;
    ListNode_7 next;
    ListNode_7(int x) {
         val = x;
         next = null;
     }
 }
