package acwing.array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author psl
 * @date 2020/6/29
 *              79. 滑动窗口的最大值
 *              解题思路：
 *              (单调队列) O(n)
 * 首先，最直接的做法当然是模拟滑动窗口的过程，每向右滑动一次都遍历一遍窗口内的数字找最大的输出，这样的复杂度是O(kn)，
 * 我们可以考虑优化一下。窗口向右滑动的过程实际上就是将处于窗口的第一个数字删除，同时在窗口的末尾添加一个新的数字，这就可以用双向队列来模拟，
 * 每次把尾部的数字弹出，再把新的数字压入到头部，然后找队列中最大的元素即可。
 *
 * 为了更快地找到最大的元素，我们可以在队列中只保留那些可能成为窗口最大元素的数字，去掉那些不可能成为窗口中最大元素的数字。
 * 考虑这样一个情况，如果队列中进来一个较大的数字，那么队列中比这个数更小的数字就不可能再成为窗口中最大的元素了，因为这个大的数字是后进来的，
 * 一定会比之前早进入窗口的小的数字要晚离开窗口，那么那些早进入且比较小的数字就“永无出头之日”，所以就可以弹出队列。
 *
 * 于是我们维护一个双向单调队列，队列放的是元素的下标。我们假设该双端队列的队头是整个队列的最大元素所在下标，至队尾下标代表的元素值依次降低。
 * 初始时单调队列为空。随着对数组的遍历过程中，每次插入元素前，首先需要看队头是否还能留在队列中，如果队头下标距离i超过了k，则应该出队。
 * 同时需要维护队列的单调性，如果nums[i]大于或等于队尾元素下标所对应的值，则当前队尾再也不可能充当某个滑动窗口的最大值了，故需要队尾出队。
 * 始终保持队中元素从队头到队尾单调递减。依次遍历一遍数组，每次队头就是每个滑动窗口的最大值所在下标。
 * 时间复杂度分析：每个元素最多入队出队一次，复杂度为O(n)
 *
 */
public class MaxInWindows {
    public int[] maxInWindows(int[] nums, int k) {
        List<Integer> temp = new ArrayList<>();
        // 采用双端队列，维护一个单调递减的队列
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i ++){
            // 这里是当队头元素的下标与当前加入元素的差值超过k时，需要移除队头元素
            if (!q.isEmpty() && q.getFirst() <= i - k )
                q.poll();
            // 当队尾的元素小于或等于需要加入值的时候，直接移除队尾元素
            while (!q.isEmpty() && nums[q.getLast()] < nums[i])
                q.pollLast();
            // 将当前元素加到适合队尾
            q.addLast(i);
            // 只要数组下标i >= k - 1开始，就需要将队首的元素放入返回的集合中
            if (i >= k - 1)
                temp.add(nums[q.getFirst()]);
        }
        int[] res = new int[temp.size()];
        int i = 0;
        for (int r : temp){
            res[i] = r;
            i ++;
        }
        return res;
    }
}
