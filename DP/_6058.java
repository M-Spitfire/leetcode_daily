package DP;

import org.junit.Test;

public class _6058 {
    public int countTexts(String pressedKeys) {
        int base = (int) (1e9 + 7);
        int[] steps = new int[]{0,0,3,3,3,3,3,4,3,4};
        char[] chs = pressedKeys.toCharArray();
        int len = chs.length;
        int[] dp = new int[len + 1];
        dp[0] = 1;
        for (int i = 0; i < len; i++){
            dp[i + 1] += dp[i];
            int step = steps[chs[i] - '0'];
            for (int j = 1; j < step && i >= j; j++){
                if (chs[i - j] != chs[i])break;
                dp[i + 1] += dp[i - j];
                dp[i + 1] = dp[i + 1] % base;
            }
        }
        return dp[len];
    }

    @Test
    public void test(){
        System.out.println(countTexts("222222222222222222222222222222222222"));
    }
}
