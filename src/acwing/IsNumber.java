package acwing;

/**
 * @author psl
 * @date 2019/9/2
 *                 31.表示数值的字符串
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 *  注意:
 * 小数可以没有整数部分，例如.123等于0.123；
 * 小数点后面可以没有数字，例如233.等于233.0；
 * 小数点前面和后面可以有数字，例如233.666;
 * 当e或E前面没有数字时，整个字符串不能表示数字，例如.e1、e1；
 * 当e或E后面没有整数时，整个字符串不能表示数字，例如12e、12e+5.4;
 *  样例：
 * 输入: "0"
 * 输出: true
 *                         解题思路：
 *                      1、先除去前后的空格
 *                      2、行首如果有+-，就忽略
 *                      3、字符串为空或者只有一个.，就不是合法数字
 *                      4、循环整个字符串，去掉以下几种情况：
 *                          (1) '.'或'e'多于1个;
 *                          (2) '.'在'e'后面出现；
 *                          (3) 'e'后面或前面为空，或者'e'前面紧跟着'.'；
 *                          (4) 'e'后面紧跟着正负号，但正负号后面为空；
 *                         时间复杂度：O(n)。就是遍历一遍字符串
 */
public class IsNumber {
    public  boolean isNumber(String s){
        //这里是去掉字符串前后的空格。其实用java自带的方法就可以 s.trim()
        int i = 0, j = s.length();
        while (i < j && s.charAt(i) == ' ') i++;
        while (i < j && s.charAt(j - 1) == ' ') j--;
        //如果i >= j 说明字符串为空了
        if (i >= j) return false;
        //去掉空格后的字符串
        s = s.substring(i,j);
        //如果第一个字符是 +/- ，就直接去掉
        if (s.charAt(0) == '+' || s.charAt(0) == '-') s = s.substring(1);
        //如果字符串为空 或者 字符串就是一个 . 返回false
        if (s.isEmpty() || (s.charAt(0) == '.' && s.length() == 1)) return false;   //+ , -, .
        //用dot记录.的数目，e记录e的数目
        int dot = 0, e = 0;

        for (int k = 0; k < s.length(); k ++){
            //如果字符属于这个区间就什么也不做
            if (s.charAt(k) >= '0' && s.charAt(k) <= '9');

            else if (s.charAt(k) == '.'){
                dot++;
                //如果小数点的数量大于1 或者 e出现在小数点的前面，返回false
                if (dot > 1 || e != 0) return false; // 123.123.12,123e.12
            }
            else if (s.charAt(k) == 'e' || s.charAt(k) == 'E'){
                e++;
                //如果k=0(代表第一个就是e) 或者 e后面没有数字 或者 e数目大于1 或者 e的前面是小数点并且小数点是字符串第一个
                //e123, 123e, 123e12e, .e1234
                if (k == 0 || k + 1 == s.length() || e > 1 || s.charAt(k - 1) == '.' && k == 1) return false;
                //如果e后面出现 +/-
                if (s.charAt(k + 1) == '+' || s.charAt(k + 1) == '-'){
                    //然后 +/- 的后面没有数字，就返回false
                    if (k + 2 == s.length()) return false; // 123e+
                    k++;
                }
            }
            //其他情况就是返回false
            else return false;
        }
        return true;
    }
}
