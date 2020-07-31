package acwing.string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author psl
 * @date 2020/5/18
 *          64. 字符流中第一个只出现一次的字符
 *          解题思路：O(n)
 *              本题采用与类似双指针法的方法，两个指针满足单调方式的移动
 *              当出现加入字符的个数大于1，就需要判断队首元素是否应该移出
 */
public class FirstAppearingOnce {
    //里面装字符出现的个数
    Map<Character, Integer> count = new HashMap<>();
    //采用队列实现双指针来移动，比较节省空间
    Queue<Character> q = new LinkedList<>();

    //Insert one char from stringstream
    public void insert(char ch){
        count.put(ch, count.get(ch) == null ? 1 : count.get(ch) + 1);
        //如果出现最新加入的字符的个数大于1的情况，就需要判断队列的队首字符出现个数是否大于1
        if (count.get(ch) > 1){
            count.put(ch, count.get(ch) + 1);
            //让队列中队首出现次数大于1的移出队列，队首永远都是保持只出现一次的字符
            while (!q.isEmpty() && count.get(q.peek()) > 1) q.poll();
        }
        //否，则直接加入队列
        else q.offer(ch);
    }
    //return the first appearence once char in current stringstream
    public char firstAppearingOnce(){
        if (q.isEmpty()) return '#';
        else return q.peek();
    }
}
