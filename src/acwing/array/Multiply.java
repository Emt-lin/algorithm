package acwing.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author psl
 * @date 2020/7/2
 *              86. 构建乘积数组
 *              解题思路：
 *                  拆分，一步不好做，拆成多步做
 *                  1、算i左半边的乘积
 *                  2、然后算i右半边的乘积
 *
 */
public class Multiply {
    public int[] multiply(int[] A) {
        if (A == null || A.length == 0) return new int[0];
        int len = A.length;
        int[] B = new int[len];
        // 使用p变量存放A[0] 到 A[i-1]的乘积 ===> 这就是算i左半边的乘积
        for (int i = 0, p = 1; i < len; i ++){
            B[i] = p;
            p *= A[i];
        }
        // 使用p变量存放 A[len-1] 到 A[i+1]的乘积  ===> 这就是算i右半边的乘积
        for (int i = len - 1, p = 1; i >=0; i --){
            B[i] *= p;
            p *= A[i];
        }
        return B;
    }
}
