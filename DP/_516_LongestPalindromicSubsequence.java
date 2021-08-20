package DP;
/*
 * @lc app=leetcode.cn id=516 lang=java
 *
 * [516] 最长回文子序列
 */

/**
 * 序列问题一般来说都是动态规划问题, 本题中的最长回文子序列也是动态规划问题
 * dp[i][j]: 字符串s从i到j的子串中最长的回文字序列的长度
 * 状态转移方程:
 * 1. s[i] == s[j]
 *      dp[i][j] = 2 + dp[i + 1][j - 1]
 * 2. s[i] != s[j]
 *      dp[i][j] = Max(dp[i + 1][j], dp[i][j - 1])
 * 
 * 初始化: 单个字符都是回文子序列
 */

public class _516_LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        char[] chs = s.toCharArray();
        int len = chs.length;
        int[][] dp = new int[len][len];

        for(int i = len - 1; i >= 0; i--){
            dp[i][i] = 1;
            for(int j = i + 1; j < len; j++){
                if(chs[i] == chs[j]){
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                }
                else{
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][len - 1];
    }
}

