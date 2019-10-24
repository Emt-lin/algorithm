package acwing.array;

/**
 * @author psl
 * @date 2019/10/14
 *          52. 数组中出现次数超过一半的数字
 *
 *
 *      解题思路：
 *          就是用cnt记录次数 和 value记录值，
 *          如果value与num不相等，cnt--
 *          如果cnt = 0，就使当前value = num，cnt = 1
 *          如果value = num ，就cnt++
 *      时间复杂度：
 */
public class MoreThanHalfNum_Solution {
    public int moreThanHalfNum_Solution(int[] nums) {
        //cnt记录当前数字的次数
        int cnt = 0;
        //value记录当前次数对应的值
        int value = -1;
        for(int num : nums){
            if(cnt == 0) {
                cnt = 1;
                value = num;
            }
            //如果当前数等于value，cnt++
            //否则，不等于cnt--
            else {
                if (num == value) cnt ++;
                else cnt --;
            }
        }
        return value;
    }
}
