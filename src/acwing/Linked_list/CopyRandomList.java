package acwing.Linked_list;

/**
 * @author psl
 * @date 2019/9/26
 *              48. 复杂链表的复刻
 * 请实现一个函数可以复制一个复杂链表。
 * 在复杂链表中，每个结点除了有一个指针指向下一个结点外，还有一个额外的指针指向链表中的任意结点或者null。
 * 注意：
 * 函数结束后原链表要与输入时保持一致。
 *                   解题思路：
 *                      就是复制每一个节点，然后拆分就行，由于random指针是一个比较重要点(需要注意)
 *                   时间复杂度：O(n)
 */
public class CopyRandomList {
    public ListNode_6 copyRandomList(ListNode_6 head) {
        //复制原链表的每一个节点
        for (ListNode_6 p = head;p != null; ){
            ListNode_6 np = new ListNode_6(p.val);
            ListNode_6 next = p.next;
            p.next = np;
            np.next = next;
            p = next;
        }
        //让复制节点的random指针指向被复制节点的random指针 指向的节点的 复制节点
        for (ListNode_6 p = head ; p != null; p = p.next.next){
            if (p.random != null) p.next.random = p.random.next;
        }
        //定义一个虚拟头结点，便于操作
        ListNode_6 dummy = new ListNode_6(-1);
        //记录复制的链表的尾部节点的指针
        ListNode_6 cur = dummy;
        //拆分复制节点后的原链表，拆分成 原链表 和 复制链表
        for (ListNode_6 p = head; p != null; p = p.next){
            cur.next = p.next;
            cur = cur.next;
            //由于要保持原链表不变，所以要修改原来链表里面节点的next指针
            p.next = cur.next;
        }
        return dummy.next;
    }
}
class ListNode_6 {
     int val;
    ListNode_6 next, random;
    ListNode_6(int x) { this.val = x; }
 }