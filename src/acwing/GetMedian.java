package acwing;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author psl
 * @date 2019/11/12
 *          54. 数据流中的中位数
 *
 *
 *          解题思路：
 *              *** 计算机执行if else的时候，会随机选一个分支执行，同时进行判断if条件是否成立，这样提高了执行效率
 *              大根堆：由于最大的在堆顶，所以存放较小的那一半元素
 *              小根堆：由于最小的在堆顶，所以存放较大的那一部分元素
 *              维持2个堆：
 *                      1、先无条件的加入大根堆
 *                      2、如果大根堆当前堆顶元素 大于 小根堆，则交换2个堆顶元素。同时大根堆的堆顶元素也是交换后的元素
 *                      3、如果大根堆的元素个数 比 小根堆的元素 + 1 还多，交把大根堆的堆顶元素移除并加入到小根堆
 *          时间复杂度：
 */
public class GetMedian {
    //大根堆
    PriorityQueue<Integer> max_heap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    //小根堆
    PriorityQueue<Integer> min_heap = new PriorityQueue<>();

    public void insert(Integer num) {
        //1、先无条件的加入大根堆
        max_heap.add(num);
        //2、如果大根堆当前堆顶元素 大于 小根堆，则交换2个堆顶元素。同时大根堆的堆顶元素也是交换后的元素
        if (min_heap.size() != 0 && max_heap.peek() > min_heap.peek()){
            Integer maxv = max_heap.poll();
            Integer minv = min_heap.poll();
            max_heap.add(minv);
            min_heap.add(maxv);
        }
        //3、如果大根堆的元素个数 比 小根堆的元素 + 1 还多，交把大根堆的堆顶元素移除并加入到小根堆
        if (max_heap.size() > min_heap.size() + 1){
            min_heap.add(max_heap.poll());
        }
    }

    public Double getMedian() {
        //如果个数为奇数，就返回大根堆的堆顶
        if (((max_heap.size() + min_heap.size()) & 1) == 1) return (double)max_heap.peek();
        return (max_heap.peek() + min_heap.peek()) / 2.0;
    }
}
