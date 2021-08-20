package DP;

/*
 * @lc app=leetcode.cn id=1449 lang=java
 *
 * [1449] 数位成本和为目标值的最大数字
 * 
 * 看了一下官方题解, dp[i]只是记录cost总和为i的最大整数的位数, 若最终dp[target]<0,则说明不存在(初始化＜0)
 * 得到dp数组后, 从最后一位开始往前遍历, 根据位数信息和cost信息, 找到每一位的数字, 拼接出最终结果
 * 
 * 这种方式明显是比我的方式更快的, 因为减少了大量的字符串拼接操作
 */

public class _1449_FromLargestIntegerWithDigitsThatAddUpToTarget {
    public String largestNumber(int[] cost, int target) {
        /**
         * dp[i]:在满足cost总和等于i的条件下, 使用整数1~n组成的最大整数
         *          这个n的取值就是第一层循环, 从1~9依次进行
         *
         * 状态转移方程:
         * 1. cost[i - 1] > target:(当前数字不可能在结果种出现)
         *      保持现状即可, 不需要改变什么
         * 2. cost[i - 1] <= target:
         *      dp[i] = max{dp[i], n + dp[i - cost[i - 1]]}
         *      n拼接到dp[i - cost[i - 1]]的最高位, 并与dp[i]比较取最大值
         *
         * 还有诸多小细节, 在代码注释中解释
         *
         */
        StringBuilder[] dp = new StringBuilder[target + 1];
        for(int i = 1; i < 10; i++){
            int c = cost[i - 1];
            if(c > target)continue; // 当前数字cost太大, 不可能出现在最终结果中
            /**
             * 一个i的花费就能达到当前要求, 进行初始化
             * 当前cost在之前还没有值, 或者现在的值比以前的大, 重新初始化一下
             * 由于i是依次增大的, 所以只要length <= 1, 那么现在的i一定更大一些
             */
            if(dp[c] == null || dp[c].length() <= 1){
                dp[c] = new StringBuilder();
                dp[c].append((char)(i + 48));
            }
            /**
             * 举个例子: 当前i的花费c为2
             * 那么只需要从dp[2]开始, 依次计算dp[4], dp[6]...
             *          从dp[3]开始, 依次计算dp[5], dp[7]...
             *          从dp[4]开始的话, 就是重复计算了
             * 这样就已经能覆盖所有可能的位置了
             */
            for(int j = c; j < 2 * c && j <= target; j++){
                for(int k = j; k <= target; k += c){
                    if(dp[k - c] == null)continue;
                    StringBuilder temp = new StringBuilder();
                    temp.append((char)(i + 48)).append(dp[k - c]);
                    if(dp[k] == null){
                        dp[k] = temp;
                    }
                    else{
                        int len1 = temp.length();
                        int len2 = dp[k].length();
                        if(len1 > len2)dp[k] = temp;
                        else if(len1 == len2){
                            int cmp = temp.compareTo(dp[k]);
                            if(cmp > 0)dp[k] = temp;
                        }
                    }
                }
            }
        }
        return dp[target] == null ? "0" :dp[target].toString();
    }
}

