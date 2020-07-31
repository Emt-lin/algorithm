package acwing.array;

/**
 * @author psl
 * @date 2019/12/18
 *          60. 礼物的最大价值
 * 在一个m×n的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物，请计算你最多能拿到多少价值的礼物？
 * 注意： m,n>0
 * 样例： 输入：
 * [ [2,3,1],
 *   [1,7,1],
 *   [4,6,1] ] 输出：19    解释：沿着路径 2→3→7→6→1 可以得到拿到最大价值礼物。
 *         解题思想：
 *          初始化 n+1 和 m+1 的数组是为了减少判断，不用判断负值
 *          f[i,j]：代表从左上角走到[i,j]这个格子时最大价值是多少
 *          f[i,j] = max(f[i-1,j], f[i,j-1]) + grid[i,j]，到达坐标为[i,j]格子时，要么从上面、要么从左边
 */
public class GetMaxValue {
    public int getMaxValue(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int f[][] = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i ++){
            for (int j = 1; j <= m; j ++){
                f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return f[n][m];
    }
}
