package acwing.string;

/**
 * @author psl
 * @date 2019/8/6
 *              替换空格
 * 请实现一个函数，把字符串中的每个空格替换成"%20"。
 *
 * 你可以假定输入字符串的长度最大是1000。
 * 注意输出字符串的长度可能大于1000。
 * 样例
 * 输入："We are happy."
 * 输出："We%20are%20happy."
 *      解题思路：
 *  就是简单的遍历就行，用一个新的StringBuffer接受
 */
public class ReplaceSpaces {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("We are happy.");
        System.out.println(replaceSpaces(str));
    }
    public static String replaceSpaces(StringBuffer str) {
        //生成一个新的StringBuffer对象
        StringBuffer newStr = new StringBuffer();
        for(int i = 0 ;i < str.length() ; i++){
            char ch = str.charAt(i);
            if (ch == ' '){
                newStr.append("%20");
            }else {
                newStr.append(ch);
            }
        }
        return newStr.toString();
    }
}
