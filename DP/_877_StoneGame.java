package DP;
/*
 * @lc app=leetcode.cn id=877 lang=java
 *
 * [877] 石子游戏
 * 在486的基础上增加了一些限制条件，虽然可以用相同的dp思路解体，但最为486的特殊情况，可以有更快的方式
 */

public class _877_StoneGame {
    /**
     * 采用486的dp思路，完全相同
     * 需要注意的是，本题题目确定不会出现平局，所以最后的判断上不用等号
     */
    // public boolean stoneGame(int[] piles) {
    //     int len = piles.length;
    //     int[][] dp = new int[len][len];
    //     for(int i = 0; i < len; i++){
    //         dp[i][i] = piles[i];
    //     }
    //     for(int i = len - 1; i >= 0; i--){
    //         for(int j = i + 1; j < len; j++){
    //             dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
    //         }
    //     }


    //     return dp[0][len - 1] > 0;
    // }

    /**
     * 下面我们来论述一下为什么有偶数堆石头时先手必胜：
     * 初始有1 ~ n一共n堆石头
     * - 若先手方先拿1号堆，那么后手方只能在2号和n号堆中选一堆（这两堆的编号都是偶数）
     * - 若先手方先拿n号堆，那么后手方只能在1号和n - 1号堆中选一堆（这两堆都是奇数）
     * - 双方各拿一堆后，先手方又可以对1 ~ n-2堆石头故技重施
     * 由此可见，先手方只要计算好奇数堆和偶数堆哪边的数量更多， 就能够保证获胜
     */
    public boolean stoneGame(int[] piles) {
        return true;
    }
}

