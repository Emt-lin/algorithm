package acwing.link;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author psl
 * @date 2019/8/6
 *           从尾到头打印链表
 * 输入一个链表的头结点，按照 从尾到头 的顺序返回节点的值。
 * 返回的结果用数组存储。
 * 样例
 * 输入：[2, 3, 5]
 * 返回：[5, 3, 2]
 *          解题思路：
 *      就是简单的从头到尾遍历一遍就行，然后就行反转
 */
public class PrintListReversingly {
    public static void main(String[] args) {

    }
    public int[] printListReversingly(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }
        Collections.reverse(list);
        int[] arr = new int[list.size()];
        int i = 0;
        for(Integer cnt : list){
            arr[i] = cnt;
            i++;
        }
        return arr;
    }
}
class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
    }
}
