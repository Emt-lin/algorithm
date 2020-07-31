package acwing.array;

import java.util.Arrays;

/**
 * @author psl
 * @date 2020/7/1
 *              81. 扑克牌的顺子
 *              解题思路：
 *                  1、删除0
 *                  2、看是否有重复数字
 *                  3、看最大值 - 最小值 的差 是否 <= 4
 *
 *
 */
public class IsContinuous {
    public boolean isContinuous(int [] numbers) {
        if (numbers.length == 0 || numbers == null) return false;
        // 先排序
        Arrays.sort(numbers);
        int k = 0;
        // 找到第一个不为0的元素的下标
        while (numbers[k] == 0) k++;
        for (int i = k + 1; i < numbers.length; i ++){
            // 如果有元素相等，说明就不满足
            if (numbers[i] == numbers[i - 1])
                return false;
        }
        // 看最大值 - 最小值 的差 是否 <= 4
        return numbers[numbers.length - 1] - numbers[k] <= 4;
    }
}
