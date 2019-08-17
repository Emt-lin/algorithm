package acwing.Linked_list;

/**
 * @author psl
 * @date 2019/8/16
 *          29. 删除链表中重复的节点
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留。
 * 样例1
 * 输入：1->2->3->3->4->4->5   输出：1->2->5
 * 样例2
 * 输入：1->1->1->2->3     输出：2->3
 *      解题思路：
 *          采用双指针法，还有用一个虚拟头结点来处理边界情况
 *      时间复杂度：O(n)
 */
public class DeleteDuplication {
    public ListNode_1 deleteDuplication(ListNode_1 head){
        //定义一个虚拟头结点，用来排除删除头结点的情况
        ListNode_1 dummy = new ListNode_1(-1);
        dummy.next = head;
        //p保存当前已经可以存在链表中的最后一个节点
        ListNode_1 p = dummy;
        while (p.next != null){

            //q表示待测的第一个节点
            ListNode_1 q = p.next;
            //遍历链表，看后面的是否等于待测的第一个节点
            while (q != null && p.next.val == q.val) q = q.next;
            //如果走的长度为一的话，直接p就等于下一个节点
            if (p.next.next == q) p = p.next;
            //否则p就等于第一个不等于待测的第一个节点,删除了中间相同的节点
            else p.next = q;
        }
        return dummy.next;
    }
}
class ListNode_1 {
     int val;
    ListNode_1 next;
     ListNode_1(int x) { val = x; }
}
