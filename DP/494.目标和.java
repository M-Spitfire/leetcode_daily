package DP;

/**
 * 本题可以转换成背包问题
 * 题意等价于: 将给定集合P拆分成两个集合A和B, 使得sum(A) - sum(B) = target
 *              其中 P = A + B
 *                  sum(P) = sum(A) + sum(B)
 *                  P中的数为非负数
 * 经过简单推导: sum(B) = (sum(P) - target) / 2  
 *              =>  sum(P) - target必须使一个偶数
 * 
 * 因此问题转换成从集合P中找到一个子集, 使子集的和等于sum(B)
 */
class leetcode_494 {

    public static int findTargetSumWays(int[] nums, int target) {
        int len = nums.length;
        int sum = 0;
        for(int n : nums){
            sum += n;
        }
        int realTarget = sum - target;
        if(realTarget < 0 || realTarget % 2 != 0)return 0;
        realTarget /= 2;
        /**
         * dp[i][j]: 在前i个数中选出若干个数, 使它们的和为j的方案的个数
         * 状态转移方程:
         * 1. j < nums[i]
         *      dp[i][j] = dp[i - 1][j]
         * 2. j >= nums[i]
         *      dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]]
         */
        int[][] dp = new int[len + 1][realTarget + 1];
        // 显然, 在零个非负数中选出若干个数, 使它们的和为0的方案有且只有一种: 啥都不选
        dp[0][0] = 1;
        for(int i = 1; i <= len; i++){
            for(int j = 0; j <= realTarget; j++){
                if(j < nums[i - 1]){
                    dp[i][j] += dp[i - 1][j];
                }
                else{
                    dp[i][j] += dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        print(dp);

        return dp[len][realTarget];
    }

    public static void print(int[][] array){
        for(int[] t : array){
            for(int n : t){
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,0};
        int res = findTargetSumWays(nums, 1);
        System.out.println(res);
    }
    
}
