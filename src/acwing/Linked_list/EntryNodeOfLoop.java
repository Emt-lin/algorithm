package acwing.Linked_list;

/**
 * @author psl
 * @date 2019/9/6
 *          34. 链表中环的入口结点
 * 给定一个链表，若其中包含环，则输出环的入口节点。
 * 若其中不包含环，则输出null。
 *          解题思路：
 *          采用双指针(快慢指针)
 *              用2个指针first、second，让first每次走一步，second每次走2步。
 *              如果second走到null，说明没有环。否则当first和second相遇，让first返回起点，second不动，
 *              然后让两个指针都每次走一步，再次相遇的地点就是环的入口
 *          时间复杂度：O(n)
 *               first：走了2x+y步
 *               second：走了2x+2y+x步
 *               由于当第一次 first 走到 b 点时，second 最多追一圈即可追上 first，
 *               所以 y 小于环的长度，所以 x+y 小于等于链表总长度。所以总时间复杂度是 O(n)。
 *        相关图片介绍：acwing/Linked_list/linked-list相关图.md
 */
public class EntryNodeOfLoop {
    public ListNode_3 entryNodeOfLoop(ListNode_3 head) {
        //定义2个指针
        ListNode_3 first = head, second = head;
        while (first != null && second != null){
            first = first.next;
            second = second.next;
            if (second != null) second = second.next;
            //2个指针第一次相遇后
            if (first == second){
                first = head;
                //当2个指针再次相遇后的点，就是环的入口
                while (first != second){
                    first = first.next;
                    second = second.next;
                }
                return first;
            }
        }
        return null;
    }
}
class ListNode_3 {
    int val;
    ListNode_3 next;
    ListNode_3(int x) {
        val = x;
        next = null;
    }
}
