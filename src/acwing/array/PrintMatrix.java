package acwing.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author psl
 * @date 2019/9/15
 *              40. 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * 样例
 * 输入：
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *          解题思路：
 *              就是 右，下，左，上，一直走，每一个方向都是走到不能走为止
 *          时间复杂度：O(n * m)
 */
public class PrintMatrix {
    public int[] printMatrix(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int n = matrix.length;
        if (n == 0) return new int[0];
        int m = matrix[0].length;
        //定义标志数组，来区分访问与未访问的元素
        boolean[][] st = new boolean[n][m];
        //定义向上、右、下、左四个方向，x和y坐标的变换
        int[] dx = {-1,0,1,0}, dy ={0,1,0,-1};
        //定义初始化的坐标
        int x = 0, y = 0, d = 1;

        for (int i = 0; i < m * n; i ++){
            res.add(matrix[x][y]);
            //标志当前数组元素已经访问
            st[x][y] = true;
            //最开始是向右走
            int a = x + dx[d], b = y + dy[d];
            if (a < 0 || a >= n || b < 0 || b >= m || st[a][b]){
                d = (d + 1) % 4;
                a = x + dx[d];
                b = y + dy[d];
            }
            x = a;
            y = b;
        }
        int[] res1 = new int[m * n];
        int i = 0;
        for(int cnt : res){
            res1[i] = cnt;
            i++;
        }
        return res1;
    }
}
