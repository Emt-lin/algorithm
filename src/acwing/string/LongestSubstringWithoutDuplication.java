package acwing.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author psl
 * @date 2020/5/17
 *              61. 最长不含重复字符的子字符串
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * 假设字符串中只包含从’a’到’z’的字符。
 * 样例
 * 输入："abcabc"
 * 输出：3
 *          解题思路：
 *              本题采用双指针算法，让j在i前面移动，添加s[j]到hash表中，然后进行判断
 *              1、当把s[j]加入到hash表中时，判断其出现个数是否大于 1，
 *                  大于 1：需要移动字符串中 i到与s[j]相同字母的位置的下一个位置，并将其个数减一
 *              2、比较前面的res 和 当前 长度的大小
 */
public class LongestSubstringWithoutDuplication {
    public int longestSubstringWithoutDuplication(String s) {
        Map<Character, Integer> count = new HashMap<>();
        int res = 0;
        for (int i = 0, j = 0; j < s.length(); j ++){
            count.put(s.charAt(j), (count.get(s.charAt(j))) == null ? 1 : count.get(s.charAt(j))+1);
            if ( count.get(s.charAt(j)) > 1){
                int tmp = count.get(s.charAt(i));
                while (tmp == 1){
                    count.put(s.charAt(i ++), --tmp);
                    tmp = count.get(s.charAt(i));
                }
                count.put(s.charAt(i ++), --tmp);
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}
