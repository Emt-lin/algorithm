package acwing.array;

/**
 * @author psl
 * @date 2019/8/11
 *              23. 矩阵中的路径
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 * 注意：
 * 输入的路径不为空；
 * 所有出现的字符均为大写英文字母；
 * 样例
 * matrix=
 * [
 *   ["A","B","C","E"],
 *   ["S","F","C","S"],
 *   ["A","D","E","E"]
 * ]
 * str="BCCE" , return "true"
 * str="ASAE" , return "false"
 *          解题思路：
 *      本题采用了深度遍历的思想，先枚举单词的起点，然后依次枚举后面的单词
 *      过程中需要将已经使用过的字母改成一个特殊字母，以避免重复使用字符。(采用回溯的思想)
 *          时间复杂度：
 *              单词起点一共有 n^2个，单词的每个字母一共有上下左右四个方向可以选择，
 *              但由于不能走回头路，
 *              所以除了单词首字母外，仅有三种选择。所以总时间复杂度是 O(n^23^k)
 *              k:路径的平均长度
 */
public class HasPath {
    public boolean hasPath(char[][] matrix, String str) {
        //转换成数组，便于后续操作
        char[] strChar = str.toCharArray();
        for(int i = 0; i < matrix.length;i ++){
            for (int j = 0; j < matrix[i].length; j ++){
                //采用遍历数组的方法，进行测试
                if (dfs(matrix, strChar,0,i,j))
                        return true;
            }
        }
        return false;
    }
    public boolean dfs(char[][] matrix, char[] str,int u,int x, int y){
        //就是如果值不相等，就立即返回false
        if (matrix[x][y] != str[u]) return false;
        //如果当前u已经到达字符串的最后，直接返回true。就是所有的字符已经找到
        if (u == str.length - 1) return true;
        //这里很巧妙。
        //用数组来表示上右下左四个方向，这样就减少写if语句
        int[] dx = {-1,0,1,0},dy = {0,1,0,-1};
        //用一个临时变量来装当前已经被匹配的字符
        char temp = matrix[x][y];
        //对这个数组坐标赋值为*，这样防止后面重新匹配这个字符
        matrix[x][y] = '*';
        //这里采用循环对上下左右四个方向进行操作
        for (int i = 0; i < 4;i ++){
            int a = x + dx[i] , b = y + dy[i];
            //判断坐标的范围，是否要进行递归操作
            if (a >=0 && a < matrix.length && b >= 0 && b < matrix[a].length){
                    //继续对后面的数进行递归操作
                    if(dfs(matrix,str,u + 1,a,b)) return true;
                }
        }
        //这里采用了回溯的思想，让数组的值保持不变。就是最后递归出来一层一层的恢复原来的值
        matrix[x][y] = temp;
        return false;
    }
}
