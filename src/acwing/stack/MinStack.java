package acwing.stack;

import java.util.LinkedList;

/**
 * @author psl
 * @date 2019/9/18
 *              41. 包含min函数的栈
 * 设计一个支持push，pop，top等操作并且可以在O(1)时间内检索出最小元素的堆栈。
 * push(x)–将元素x插入栈中
 * pop()–移除栈顶元素
 * top()–得到栈顶元素
 * getMin()–得到栈中最小元素
 *          解题思路：
 *              维护一个单调栈来实现返回最小值的操作
 *              如何维护单调栈：
 *                  1、当我们向栈中压入一个数时，单调栈的元素 >= 要插入的数，就要往单调栈里面压入这个元素。
 *                  2、否则，就不压入，这是由于栈有先进后出的特点，在这元素弹出之前，栈中一定有一个比它小的元素
 *                  3、当我们从栈中弹出一个数时，如果该数等于单调栈的栈顶元素，则同时将单调栈的栈顶元素弹出
 *                  4、单调栈由于其具有单调性，所以它的栈顶元素，就是当前栈中的最小数。
 *          时间复杂度：O(1)
 */
public class MinStack {
    //正常装元素的栈
    LinkedList<Integer> stackValue = new LinkedList<>();
    //维护的一个单调栈
    LinkedList<Integer> stackMin = new LinkedList<>();
    public MinStack() {
    }

    public void push(int x) {
        stackValue.push(x);
        //如果栈为空，或者单调栈的元素 >= 要插入的数，就要往单调栈里面压入这个元素
        if (stackMin.isEmpty() || stackMin.peekFirst() >= x) stackMin.push(x);
    }

    public void pop() {
        //如果普通栈和单调栈的栈顶元素相等，就要弹出单调栈的元素
        if (stackMin.peekFirst() == stackValue.peekFirst()) stackMin.poll();
        stackValue.poll();
    }

    public int top() {
        return stackValue.peekFirst();
    }

    public int getMin() {
        return stackMin.peekFirst();
    }
}
