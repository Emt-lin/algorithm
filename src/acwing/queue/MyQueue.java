package acwing.queue;

import java.util.LinkedList;

/**
 * @author psl
 * @date 2019/8/9
 *          用两个栈实现队列
 * 请用栈实现一个队列，支持如下四种操作：
 *
 * push(x) – 将元素x插到队尾；  pop() – 将队首的元素弹出，并返回该元素；
 * peek() – 返回队首元素； empty() – 返回队列是否为空
 *注意：
 * 你只能使用栈的标准操作：push to top，peek/pop from top, size 和 is empty；
 * 如果你选择的编程语言没有栈的标准库，你可以使用list或者deque等模拟栈的操作；
 * 输入数据保证合法，例如，在队列为空时，不会进行pop或者peek等操作；
 *  样例
 * MyQueue queue = new MyQueue();
 * queue.push(1);   queue.push(2);  queue.peek();  // returns 1
 * queue.pop();   // returns 1  queue.empty(); // returns false
 *  找出每一个节点的后继，时间复杂度为O(n)
 *          解题思路：
 *      就是用另一个栈装从第一个栈里面的元素,相应的操作对应就行
 */
public class MyQueue {
    LinkedList<Integer> stack = new LinkedList<>();
    LinkedList<Integer> cache = new LinkedList<>();
    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    //直接插入第一个栈就行
    public void push(int x) {
        stack.push(x);
    }
    //这个方法是将第一个栈清空，并将其中的值装入另一个栈里面
    void copy(LinkedList<Integer> stack,LinkedList<Integer> cache){
        while (stack.size() != 0){
            cache.push(stack.pop());
        }
    }
    /** Removes the element from in front of queue and returns that element. */

    public int pop() {
        copy(stack,cache);
        int res = cache.pop();
        copy(cache,stack);
        return res;
    }

    /** Get the front element. */
    public int peek() {
        copy(stack,cache);
        int res = cache.peek();
        copy(cache,stack);
        return res;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}
