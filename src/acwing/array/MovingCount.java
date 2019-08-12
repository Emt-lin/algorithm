package acwing.array;

import java.util.*;

/**
 * @author psl
 * @date 2019/8/12
 *          24. 机器人的运动范围
 * 地上有一个 m 行和 n 列的方格，横纵坐标范围分别是 0∼m−1 和 0∼n−1。
 * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格。
 * 但是不能进入行坐标和列坐标的数位之和大于 k 的格子。
 * 请问该机器人能够达到多少个格子？
 * 样例1  输入：k=7, m=4, n=5    输出：20
 * 样例2  输入：k=18, m=40, n=40 输出：1484
 * 解释：当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 *       但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
 *  注意:
 * 0<=m<=50     0<=n<=50    0<=k<=100
 *      解题思路：
 *    采用bfs(广度优先遍历)方式进行搜索，从(0, 0) 点开始，然后四个方向扩展
 *      扩展时注意：
 *          在范围内、这个点是否已经走过、数位和小于k
 *      时间复杂度：
 *          最多全部走一遍，所以为O(nm)
 *
 */
public class MovingCount {
    public int movingCount(int threshold, int rows, int cols){
        //用来记录多少格子的
        int res = 0;
        if (rows == 0 || cols == 0) return 0;
        //st二维数组用来记录当前位置是否已经走过
        boolean[][] st = new boolean[rows][cols];
        //采用广度优先，用此队列来保存
        Queue<Num> q = new LinkedList<>();
        //初始化装入零号位置的元素，这里自定义一个类来装：x，y坐标
        q.add(new Num(0,0));
        //用一个数组来表示上、右、下、左
        int[] dx = {-1,0,1,0},dy = {0,1,0,-1};
        //当队列不为空，就继续找
        while (q.size() != 0){
            //出队首元素
            Num temp = q.poll();
            //如果值大于k或者当前位置已经走过，进入下一次循环
            if (get_sum(temp) > threshold || st[temp.x][temp.y]) continue;
            //数量加一
            res++;
            //设置当前位置已经走过
            st[temp.x][temp.y] = true;
            //对这个位置的四个方向进行遍历
            for(int i = 0; i < 4; i ++){
                int x = temp.x + dx[i], y = temp.y + dy[i];
                if (x >= 0 && x < rows && y >= 0 && y < cols){
                    //如果在数组中，就放入队列
                    q.add(new Num(x,y));
                }
            }
        }
        return res;
    }
    //得到一个数的数位和
    int get_single_sum(int x){
        int s = 0;
        while (x != 0){
            s += x % 10;
            x /= 10;
        }
        return s;
    }
    //得到一个坐标的数位和
    int get_sum(Num p){
        return get_single_sum(p.x) + get_single_sum(p.y);
    }

}
//这个类用来保存x，y坐标
class Num{
    int x;
    int y;
    public Num(int x,int y){
        this.x = x;
        this.y = y;
    }
}
