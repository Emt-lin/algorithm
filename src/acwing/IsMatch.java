package acwing;

/**
 * @author psl
 * @date 2019/8/16
 *          30. 正则表达式匹配
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配。
 * 样例
 * 输入： s="aa" p="a*"
 * 输出:true
 *          解题思路：
 *         状态表示：    f[i][j] 表示s[i,....]和p[j,...]相匹配
 *         状态转移：
 *         1、如果p[j]是正常字符，f[i][j] = s[i] == p[j] && f[i+1][j+1]
 *         2、如果p[j]='.'，f[i][j] = f[i+1][j+1]
 *         3、如果p[j+1]是'*'，f[i][j] = f[i][j+2] || f[i+1][j] && s[i] == p[j]
 *
 *         边界：f[n][m] = true
 *          时间复杂度：O(mn)
 */
public class IsMatch {
    int n, m;
    String s, p;
    boolean[][] f;
    public boolean isMatch(String _s, String _p) {
        s = _s;
        p = _p;
        n = s.length();
        m = p.length();
        f = new boolean[n+1][m+1];
        return dp(0,0);
    }
    boolean dp(int x, int y){
        if (f[x][y]) return f[x][y];
        if (y == m){
            return f[x][y] = x == n;
        }
        boolean first_match = x < n && (p.charAt(y) == '.' || p.charAt(y) == s.charAt(x));
        if (y + 1 < m && p.charAt(y + 1) == '*'){
            f[x][y] =  dp(x,y + 2) || first_match && dp(x + 1, y);
        }else {
            f[x][y] =  first_match && dp(x + 1, y + 1);
        }
        return f[x][y];
    }
}
