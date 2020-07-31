package acwing.string;

import java.util.Arrays;

/**
 * @author psl
 * @date 2020/6/29
 *          77. 翻转单词顺序
 *          解题思路：
 *              当一步到位的思路难做时，可以采用操作分解的角度做
 *              1、翻转整个句子
 *              2、翻转每个单词
 *
 */
public class ReverseWords {
    public String reverseWords(String s) {
        // 翻转整个句子
        StringBuffer reverse = new StringBuffer(s).reverse();
        for (int i = 0; i < reverse.length(); i ++){
            int j = i;
            while (j < reverse.length() && reverse.charAt(j) != ' ') j ++;
            // 翻转每个单词
            String tmp = new StringBuffer(reverse.substring(i, j)).reverse().toString();
            reverse.replace(i, j, tmp);
            i = j;
        }
        return reverse.toString();
    }
}
