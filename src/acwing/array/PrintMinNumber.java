package acwing.array;

import java.util.*;

/**
 * @author psl
 * @date 2019/11/19
 *          58. 把数组排成最小的数
 *
 *
 *              解题思路：
 *                  满足：反对称性，传递性
 *                      详情请见图片
 *                  image：acwing 58.png
 *              时间复杂度：
 */
public class PrintMinNumber {
    public String printMinNumber(int[] nums) {

        String res = "";
        if (nums.length == 0) return res;
        List<Integer> newNums = new ArrayList<>();
        for (Integer num : nums){
            newNums.add(num);
        }
        //定义一个新的排序方法：a,b两个数，如果ab < ba ,<——> a排在b前面
        newNums.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                    String as = a.toString(), bs = b.toString();
                    return (as + bs).compareTo(bs + as);
            }
        });
        for(Integer num : newNums){
            res += num;
        }
        /*//第二种
        Integer[] nu = new Integer[nums.length];
        for(int i = 0; i < nums.length; i ++){
            nu[i] = nums[i];
        }
        Arrays.sort(nu, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                String as = a.toString(), bs = b.toString();
                return (as + bs).compareTo(bs + as);
            }
        });
        for(Integer num : nu){
            res += num;
        }*/
        return res;
    }

}