package DFS;


/*
 * @lc app=leetcode.cn id=576 lang=java
 *
 * [576] 出界的路径数
 */

/**
 * 记忆化搜索
 * 深度优先搜索 + 哈希表记录中间结果
 * 
 * 依照记忆化搜索的过程, 我们可以发现结果是从边界开始往起点计算的, 依照这一点, 我们可以使用DP来解决本题
*/

public class _576_OutOfBoundaryPaths {
    int[][] move = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };
    int[][][] cache;
    int M;
    int N;
    int MOD = (int)1e9 + 7;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        cache = new int[m][n][maxMove + 1];
        M = m;
        N = n;

        //在搜索过程中, 有些点在规定的步数下是不可能走出去的, 因此它们存储的值为0
        //故这里初始化为-1, 用作区分
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k <= maxMove; k++){
                    cache[i][j][k] = -1;
                }
            }
        }

        //这里使用深度优先搜索
        return dfs(startRow, startColumn, maxMove);
    }

    public int dfs(int row, int column, int depth){
        // 下面这两个判断的顺序不能调换, 为了解决刚好最后一步走出边界的情况
        if(row < 0 || row >= M || column < 0 || column >= N)return 1;
        if(depth == 0)return 0;

        if(cache[row][column][depth] != -1)return cache[row][column][depth];
        int res = 0;
        for(int[] next : move){
            int newRow = row + next[0];
            int newColumn = column + next[1];
            res += dfs(newRow, newColumn, depth - 1);
            res %= MOD;
        }
        cache[row][column][depth] = res;
        return res;
    }
}

