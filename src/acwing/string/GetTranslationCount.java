package acwing.string;

/**
 * @author psl
 * @date 2019/11/20
 *          59. 把数字翻译成字符串
 *
 *
 *
 *                  解题思路：dp问题：1、状态表示   2、状态如何计算  3、边界如何定义。  组合数学：加法原理和乘法原理
 *
 *                  时间复杂度：O(n)
 */
public class GetTranslationCount {
    public int getTranslationCount(String s) {
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i ++){
            //当i位单独做一个字符时
            f[i] = f[i - 1];
            if (i > 1){
                int t = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');
                //当第i位和i-1位做一个字符时，但是要排除 03 04 05 这种情况，还有比25大的情况
                if (t >= 10 && t <= 25) f[i] += f[i - 2];
            }

        }
        return f[n];
    }
}
