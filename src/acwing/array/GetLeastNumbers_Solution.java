package acwing.array;

import java.util.*;

/**
 * @author psl
 * @date 2019/10/24
 *              53. 最小的k个数
 *
 *      解题思路：
 *          主要利用了大顶堆，大顶堆的堆顶元素永远都是最大的，所以只需比较当前堆顶元素和新加入的元素的大小
 *      时间复杂度：O(log k)
 *
 *      更重要的是代码复杂度
 */
public class GetLeastNumbers_Solution {
    public List<Integer> getLeastNumbers_Solution(int [] input, int k) {
        //如果k = 0， 直接返回一个空的就行
        if (k == 0) return new ArrayList<Integer>();
        //初识化一个容量为k的大顶堆(利用java的优先队列)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            //改变比较器，让小顶堆变成大顶堆
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        //直接遍历输入集合，然后只要新加入的元素比堆顶小，就让当前堆顶元素去除，然后把新元素加入
        for(int num : input){
            maxHeap.add(num);
            if (maxHeap.size() > k ) maxHeap.poll();
        }
        List<Integer> res = new ArrayList<>();
        //遍历出堆里面的元素，装入集合res
        while (maxHeap.size() != 0){
            res.add(maxHeap.poll());
        }
        Collections.reverse(res);
        return res;
    }
}
