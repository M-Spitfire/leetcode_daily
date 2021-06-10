package DP;

/**
 * leetcode_474
 */

class leetcode_474 {

    public static int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        Integer[] count1 = new Integer[len];
        Integer[] count0 = new Integer[len];
        for(int i = 0; i < len; i++){
            count0[i] = countZero(strs[i]);
            count1[i] = strs[i].length() - count0[i];
        }

        // 使用01背包的思路(需要同时满足两种容量条件的零一背包)
        /**
         * dp[i][j][k]: 在前i个字符串中,满足0的总个数不大于j且1的总个数不大于k的字符串的个数
         * 因此最终结果就是do[len][m][n]
         * 
         * 下面是状态转移成成:
         * 1. 如果0的总个数大于j或1的总个数大于k, 则不可能再添加任何字符串
         *      dp[i][j][k] = dp[i - 1][j][k]
         * 2. 如果0的总个数不大于j且1的总个数不大于k, 则需要考虑两种情况取最大值
         *      a = dp[i - 1][j][k]
         *      b = dp[i - 1][j - zero][k - one] + 1 (zero:当前字符串0的个数; one:当前字符串1的个数)
         *      dp[i][j][k] = max{a, b}
         */
        int[][][] dp = new int[len + 1][m + 1][n + 1];
        for(int i = 1; i <= len; i++){
            for(int j = 0; j <= m; j++){
                for(int k = 0; k <= n; k++){
                    dp[i][j][k] = dp[i - 1][j][k];
                    int zero = count0[i - 1];
                    int one = count1[i - 1];
                    if(j >= zero && k >= one){
                        dp[i][j][k] = Math.max(dp[i][j][k], 1 + dp[i - 1][j - zero][k - one]);
                    }
                }
            }
        }
        return dp[len][m][n];
    }

    public static int countZero(String str){
        int res = 0;
        int len = str.length();
        for(int i = 0; i < len; i++){
            if(str.charAt(i) == '0')res++;
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        System.out.println(findMaxForm(strs, 5, 3));
        
    }

    public static <T> void print(T[] array){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    
}