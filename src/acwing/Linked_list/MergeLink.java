package acwing.Linked_list;

/**
 * @author psl
 * @date 2019/9/9
 *          36. 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的。
 * 样例
 * 输入：1->3->5 , 2->4->5
 * 输出：1->2->3->4->5->5
 *
 *          解题思路：
 *            采用双指针法，两个分别指向两个链表
 *              定义一个虚拟头结点  ————> 保护结点
 *              定义一个cursor指针指向合并后的链表的最后的元素
 *          时间复杂度：O(n)
 *
 */
public class MergeLink {
    public ListNode_5 merge(ListNode_5 l1, ListNode_5 l2) {
        //定义一个虚拟头结点，保护结点
        ListNode_5 dummy = new ListNode_5(-1);
        //定义一个cursor指针指向合并后的链表的最后的元素
        ListNode_5 cur = dummy;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                cur.next = l1;
                cur = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                cur = l2;
                l2 = l2.next;
            }
        }
        if (l1 != null) cur.next = l1;
        else cur.next = l2;
        return dummy.next;
    }
}
class ListNode_5 {
    int val;
    ListNode_5 next;
    ListNode_5(int x) {
        val = x;
        next = null;
    }
}
