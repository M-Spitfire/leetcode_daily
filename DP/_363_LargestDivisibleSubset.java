package DP;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode_368
 * 
 * 动态规划
 * 由题意可得, 最大整除子集的定义:集合中任意两个元素n和m(假设n > m), 必须满足n是m的整数倍
 * 
 * 思路:
 * 1. 先将数组nums排序, 确保后面的大于前面的(题目保证无重复数字)
 * 2. 定义dp[i]: 以nums[i]为最大数字的最大整除子集的大小
 * 3. 状态转移方程: dp[i] = 1 + max(dp[j]), 其中 0 <= j < i
 * 4. 从后往前遍历dp数组, 根据能否整除和dp[i]的值就能确定最终结果
 */
public class _363_LargestDivisibleSubset {
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.sort(nums);

        int maxSize = 1;    //记录最大整除子集的大小
        int maxSizeIndex = 0;   //记录最大整除子集中最大的数的索引
        //求dp数组
        for(int i = 0; i < nums.length; i++){
            for(int j = i - 1; j >= 0; j--){
                if(nums[i] % nums[j] == 0){
                    /**
                     * 这里要遍历所有前面的值的原因:
                     * nums: [4, 8, 10, 240], 前面3个值的dp值分别为[1, 2, 1];
                     * 如果只是找到最大的能够整除的数的话, 就会选中10, 而我们真正的目标是8
                     * 因此不能用下面这种写法
                     * dp[i] = dp[j] + 1;
                     * if(dp[i] > maxSize){
                     *      maxSize = dp[i];
                     *      maxSizeIndex = i;
                     * }
                     * break;
                     */
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if(dp[i] > maxSize){
                        maxSize = dp[i];
                        maxSizeIndex = i;
                    }
                }
            }
        }

        // printArray(nums);
        // printArray(dp);

        //如果最大整除子集的大小为1, 那么任意元素都是答案
        ArrayList<Integer> res = new ArrayList<>();
        if(maxSize == 1){
            res.add(nums[0]);
            return res;
        }

        //找到最大整除子集的所有元素并返回
        int pre = nums[maxSizeIndex];
        res.add(pre);
        maxSize--;
        for(int i = maxSizeIndex - 1; i >= 0; i--){
            if(dp[i] == maxSize && pre % nums[i] == 0){
                pre = nums[i];
                res.add(pre);
                maxSize--;
            }
        }

        return res;
    }
}
