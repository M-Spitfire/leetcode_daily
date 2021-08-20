package DP;/*
 * @lc app=leetcode.cn id=279 lang=java
 *
 * [279] 完全平方数
 * 
 * 多重背包问题, 就是饶了一个弯子, 没有直接提供"硬币的种类"
 * 
 * 除了动态规划之外, 本题还有数学方法可解: 四平方和定理
 * 又比动态规划块上一个量级
 */

public class _279_PerfectSquare {
    /**
     * 注意到在这种动态规划方式中, 当前需要计算的行只与上一行的数据有关, 显然可以对空间进行优化
     */
    // public static int numSquares(int n) {
    //     int len = (int) Math.sqrt(n);
    //     int[] square = new int[len];
    //     for(int i = 0; i < len; i++){
    //         square[i] = (i + 1) * (i + 1);
    //     }
    //     /**
    //      * dp[i][j]: 在square[]的前i个数字种选出若干个(可重复使用), 使的它们的和为j的数字的最小数量
    //      *
    //      * 定义好dp数组后, 状态转移方程就不难写出来了, 这里就不写了
    //      */
    //     int[][] dp = new int[len + 1][n + 1];
    //     for(int i = 1; i <= n; i++){
    //         dp[1][i] = i;
    //     }
    //     for(int i = 2; i <= len; i++){
    //         int cur = square[i - 1];
    //         for(int j = 1; j <= n; j++){
    //             dp[i][j] = dp[i - 1][j];
    //             if(j >= cur){
    //                 dp[i][j] = Math.min(dp[i][j], 1 + dp[i - 1][j - cur]);
    //             }
    //         }
    //     }
    //     return dp[len][n];
    // }


    /**
     * 这里对空间的优化实际上与518非常相似
     */
    public static int numSquares(int n) {
        int len = (int) Math.sqrt(n);
        /**
         * dp[i]: 找到n个完全平方数, 使的它们的和为j. 找到n的最小值
         *
         * 初始化:
         * 每个数a都能用a个1加出来
         *
         * 状态转移方程:应该不难找出, 略
         *
         */
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i++){
            dp[i] = i;
        }
        for(int i = 2; i <= len; i++){
            int cur = i * i;
            for(int j = cur; j <= n; j++){
                dp[j] = Math.min(dp[j], 1 + dp[j - cur]);
            }
        }
        return dp[n];
    }
}

