package acwing.stack;

import java.util.LinkedList;

/**
 * @author psl
 * @date 2019/9/20
 *          42. 栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * 注意：若两个序列长度不等则视为并不是一个栈的压入、弹出序列。若两个序列都为空，则视为是一个栈的压入、弹出序列。
 * 样例
 * 输入：[1,2,3,4,5]
 *      [4,5,3,2,1]
 * 输出：true
 *          解题思路：
 *              先入栈当前元素，如果当前要入栈的元素 是否等于 弹出序列当前下标处的元素，然后弹出元素。最后判断栈是否为空
 *          时间复杂度：O(n)
 */
public class IsPopOrder {
    public boolean isPopOrder(int [] pushV,int [] popV) {
        if (pushV.length != popV.length) return false;
        LinkedList<Integer> push = new LinkedList<>();
        int i = 0;
        for (int num : pushV){
            push.push(num);
            while (!push.isEmpty() && push.peekFirst() == popV[i]){
                    push.poll();
                    i++;
            }
        }
        return push.isEmpty();
    }
}
