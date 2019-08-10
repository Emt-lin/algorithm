package acwing.fibonacci;

/**
 * @author psl
 * @date 2019/8/9
     *          斐波那契数列
 *    输入一个整数 n ，求斐波那契数列的第 n 项。
 *
 * 假定从0开始，第0项为0。(n<=39)
 */
public class Fibonacci {
    public int fibonacci(int n) {
        int a = 0 ,b = 1;
        while ( n -- != 0 ){
            int c = a + b;
            a = b;
            b = c;
        }
        return a;
    }
}
