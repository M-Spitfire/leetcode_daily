package DP;

/**
 * 完全背包问题, 动态规划
 */
public class _518_CoinChange2 {
    /**
     * 没有优化空间的写法
     */
    // public static int change(int amount, int[] coins) {
    //     int len = coins.length;
    //     /**
    //      * dp[i][j]:使用前i种硬币(每种硬币的个数任意)凑出j元的方案的数量
    //      *
    //      * 初始化:
    //      * dp[0][0] = 1
    //      *
    //      * 状态转移方程:
    //      * 1. 当前硬币不可能是结果中的一员(coins[i] > amount)
    //      *      dp[i][j] = dp[i - 1][j]
    //      * 2. 当前硬币有可能存在与正确的方案中(conis[i] <= amount)
    //      *      coin = coins[i]
    //      *      dp[i][j] = sum{dp[i - 1][j - n * coin] | j - n * coin >= 0}
    //      */
    //     int[][] dp = new int[len + 1][amount + 1];
    //     dp[0][0] = 1;
    //     for(int i = 1; i <= len; i++){
    //         int coin = coins[i - 1];
    //         for(int j = 0; j <= amount; j++){
    //             if(coin > amount){
    //                 dp[i][j] = dp[i - 1][j];
    //             }
    //             else{
    //                 for(int k = 0; k * coin <= j; k++){
    //                     dp[i][j] += dp[i - 1][j - k * coin];
    //                 }
    //             }
    //         }
    //     }

    //     return dp[len][amount];
    // }

    /**
     * 上面的写法完全正确, 但是有一些复杂了, 有没有更简单的动态规划的方式呢? 其实是有的
     * 我们回想一下爬楼梯那个题目, 如果我们一次只能爬1或2阶台阶, 那么dp[i] = dp[i - 1] + dp[i - 2]
     * 在本题中, 我们也可以使用相同的思路
     */
    public static int change(int amount, int[] coins) {
        /**
         * dp[i]:硬币总和为i的方案数
         *
         * 初始化:dp[0] = 1
         * 不选择任何硬币就能完成总和为0的目标
         *
         * 状态转移方程:
         * 一种coin就代表我们一次能走的步数, 每一种可能都要加上
         * for(int coin : coins){
         *     dp[i] = dp[i] + dp[i - coin];
         * }
         * 其中, i - coin >= 0
         */
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        /**
         * 值得注意的是, 这里的两个for循环还有一些门道
         * 先遍历coins再遍历dp数组, 得到的结果是组合数
         * 先遍历dp数组再遍历coins, 扽到的结果是排列数
         * 解释一下组合数就能明白了:
         * 我们有{1,2}两种硬币, 想要得到总和为3的方案数
         * 遍历硬币1时, 我们能够得到第一种方案[1,1,1]
         * 遍历硬币2时, 我们只能够得到一种方案[1,2], 这个2不可能跑到1的前面去, 因此在结果中不会出现[1,2], [2,1]同时出现的情况, 也就是说他们两个只算一个, 因此是组合数
         */
        for(int coin : coins){
            for(int i = coin; i <= amount; i++){    //从coin开始, 因为i < coin时, 是不可能使用coin达到i的
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }
}
