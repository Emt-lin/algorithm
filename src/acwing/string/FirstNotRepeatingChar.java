package acwing.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author psl
 * @date 2020/5/17
 *          63. 字符串中第一个只出现一次的字符
 * 在字符串中找出第一个只出现一次的字符。
 * 如输入"abaccdeff"，则输出b。
 * 如果字符串中不存在只出现一次的字符，返回#字符。
 * 样例：
 * 输入："abaccdeff"
 * 输出：'b'
 *          解题思路：
 *              本题就是采用hash表而已
 */
public class FirstNotRepeatingChar {
    public char firstNotRepeatingChar(String s) {
        Map<Character, Integer> count = new HashMap<>();
        for(char c : s.toCharArray()){
            if (count.get(c) == null){
                count.put(c, 1);
            }else {
                count.put(c, count.get(c) + 1);
            }
        }
        char res = '#';
        for(char c : s.toCharArray()){
            if (count.get(c) == 1) {
                res = c;
                break;
            }

        }
        return res;
    }
}

