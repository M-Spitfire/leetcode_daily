package DP;
/**
 * leetcode_1049
 * 首先举一个简单的例子: stones[1,2,3] => 显然最终结果是0
 * 观察一下得到结果的步骤:
 * 1. 3 - 1 = 2 => stones[2,2]
 * 2. 2 - 2 = 0 => stones[0]
 * 整合起来就是: 2 - (3 - 1) => 1 + 2 - 3
 * 由此可见最终结果一定是下面这种情况:
 * 在stones中的各个值的前面填上＋或-形成一个算式, 使得算是的结果res最小且res为非负数(一直都是大的减小的, 不可能为负)
 * 
 * 
 * 这样, 本题也就转化成了和494差不多的题目, 顺理成章的使用0-1背包的思路即可解决
 * 题意等价于: 将给定集合stones拆分成两个集合A和B, sum(A) - sum(B) = diff, 使得diff最小
 *              其中 stones = A + B
 *                  sum(P) = sum(A) + sum(B)
 *                  P中的数为非负数
 * 经过简单推导: diff = sum(stones) - 2 * sum(B) 
 * 
 * 要求diff >= 0且尽可能的小, 
 * 就是要求找到stones的子集B, 使得2 * sum(B) <= sum(stones)且sum(stones)尽可能大
 * 这样问题就可以使用0-1背包解决了
 */
public class _1040_MovingStonesUntilConsecutiveII {
    public int lastStoneWeightII(int[] stones) {
        int len = stones.length;
        int sum = 0;
        for(int i = 0; i < len; i++){
            sum += stones[i];
        }
        int target = sum / 2;

        /**
         * dp[i][j]: 在前i个数中选出若干个数, 使其和sum在不超过j的前提下极可能大
         * dp[i][j] = sum
         * 状态转移方程:
         * 1. j < stones[i]
         *      dp[i][j] = dp[i - 1][j]
         * 2. j >= stones[i]
         *      dp[i][j] = max{dp[i - 1][j], dp[i - 1][j - stones[i]] + stones[i]}
         * 初始化:
         * 前0个数选出若干个数的和显然只能为0, 在java中正好是默认初始化的值, 因此不用特意初始化
         */
        int[][] dp = new int[len + 1][target + 1];
        for(int i = 1; i <= len; i++){
            for(int j = 0; j <= target; j++){
                dp[i][j] = dp[i - 1][j];
                if(j >= stones[i - 1]){
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
                }
            }
        }

        return sum - 2 * dp[len][target];
    }
}