package Greedy;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1833 lang=java
 *
 * [1833] 雪糕的最大数量
 * 贪心问题, 与背包问题非常相似, 但是本题选取的顺序可以是任意的, 因此用贪心做是更加简单明了的方式
 */

public class _1833_MaximumIceCreamBars {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int c = 0;
        int res = 0;
        for(int n : costs){
            c += n;
            if(c > coins){
                return res;
            }
            else{
                res++;
            }
        }
        return res;
    }
}

