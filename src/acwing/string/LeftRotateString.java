package acwing.string;

/**
 * @author psl
 * @date 2020/6/29
 *              78. 左旋转字符串
 *              解题思路：
 *                  1、先翻转整个字符串          abcdef => fedcba 需要：cdefab
 *                  2、然后在分别翻转后k个字符，和翻转除了后k的字符外的字符
 */
public class LeftRotateString {
    public String leftRotateString(String str,int n) {
        StringBuffer reverse = new StringBuffer(str).reverse();
        // 翻转length - n 到 末尾
        reverse.replace(str.length() - n,str.length(),
                new StringBuffer(reverse.substring(str.length() - n)).reverse().toString());
        // 翻转0 到 length - n
        reverse.replace(0, str.length() - n,
                new StringBuffer(reverse.substring(0, str.length() - n)).reverse().toString());
        return reverse.toString();
    }
}
