package DP;
/*
 * @lc app=leetcode.cn id=486 lang=java
 *
 * [486] 预测赢家
 * 与背包问题完全不同的动态规划方式
 * 
 * 有一个需要注意的点：当nums的长度为偶数时，先手方必胜，这一点在877中详细解释
 */

// @lc code=start
class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int len = nums.length;
        /**
         * 由于每一次拿走的都是头部或尾部的分数，所以剩下的一定是在nums中连续的一段，根据这点可以设计一个动态规划的方法
         * dp[i][j]：当剩余分数是nums[i]到nums[j]时，先手方和后手方石头总和的差值
         * 
         * 初始化：
         * 1. 我们规定剩余的是i~j的分数， 因此i <= j才有意义， 故dp[i][j] = 0(i > j)
         * 2. 当i == j时，剩余一堆石头， 已经没有选择的权力， 因此dp[i][i] = nums[i]
         * 
         * 状态转移方程：
         * dp[i][j] = max{nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]}
         * 解释一下为什么是减法：
         * 在上面的dp定义中，我们并没有先后手的规定，因此在各个dp[i][j]处拿石头的人不一定是同一个人
         * 我们唯一能够确定的就是：先后手双方是轮流依次拿的
         * piles[i]代表我这次拿的个数，dp[i + 1][j]表示在我这次拿之前， 你对我的领先是多少（可能是负数）
         * 因此是用减法
         * piles[j] - dp[i][j - 1]同理
         */
        int[][] dp = new int[len][len];
        for(int i = 0; i < len; i++){
            dp[i][i] = nums[i];
        }
        for(int i = len - 1; i >= 0; i--){
            for(int j = i + 1; j < len; j++){
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][len - 1] >= 0; //即使双方分数相同，在本题中也算赢
    }
}
// @lc code=end

