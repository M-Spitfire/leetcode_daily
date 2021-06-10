package DP;

/**
 * 这题同样是背包问题, 但是容量限制有两个:人数和最小利润
 */
class leetcode_879 {

    public static int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int len = group.length;
        /**
         * dp[i][j][k]:
         * 在前i个profit中选若干个个数, 
         * 使它们的和大于等于k, 且每个profit对应的group的和小于等于j的方案的个数
         * 
         * 初始化: dp[0][0][0] = 1
         * 显然, 当工作数量, 人数要求和最小利润要求都是0时, 不选择任何工作是完成目标的唯一方式
         * 但是若工作数量为0, 人数要求或者最小利润要求大于0时, 显然是不可能完成的
         * 
         * 状态转移方程:
         * group[i]:完成当前任务需要的人数
         * j:当前一共拥有的人数
         * 1. 当前人数不能完成当前工作(group[i] > j)
         *      dp[i][j][k] = dp[i - 1][j][k]
         * 2. 当前人数可以完成当前任务(group[i] <= j)
         *      dp[i][j][k] = dp[i - 1][j][k] + dp[i - 1][j - group[i]][max{0, k - profit[i]}]
         */
        int[][][] dp = new int[len + 1][n + 1][minProfit + 1];
        dp[0][0][0] = 1;
        for(int i = 1; i <= len; i++){
            int nums = group[i - 1];
            int p = profit[i - 1];
            for(int j = 0; j <= n; j++){
                for(int k = 0; k <= minProfit; k++){
                    if(group[i - 1] > j){
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                    else{
                        dp[i][j][k] = (dp[i - 1][j][k] + dp[i - 1][j - nums][Math.max(0, k - p)]) % 1000000007;
                    }
                }
            }
        }

        int res = 0;
        for(int i = 0; i <= n; i++){
            res = (res + dp[len][i][minProfit]) % 1000000007;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] group = {80,40};
        int[] profit = {88,88};
        int res = profitableSchemes(64, 0, group, profit);
        System.out.println(res);
    }
}
