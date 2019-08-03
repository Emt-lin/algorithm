package leetcode;

import java.util.Arrays;

/**
 * @author psl
 * @date 2019/6/27
 */
public class Demo {
    public static Demo d1 = new Demo();
    public static Demo d2 = new Demo();
     {
        System.out.println("构造块");
    }
    static {
        System.out.println("静态块");
    }
    public static void main(String[] args) {
//        Demo demo = new Demo();
        String  s = "haha";
        s.indexOf("");

    }
}
