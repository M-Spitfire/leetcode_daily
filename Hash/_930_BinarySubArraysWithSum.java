package Hash;

/*
 * @lc app=leetcode.cn id=930 lang=java
 *
 * [930] 和相同的二元子数组
 * 
 * 滑动窗口更快, 但是没有哈希表来的简单直观
 */

public class _930_BinarySubArraysWithSum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int res = 0;
        int len = nums.length;
        int[] map = new int[len + 1];
        map[0] = 1;
        int sum = 0;
        for(int i = 0; i < len; i++){
            sum += nums[i];
            int temp = sum - goal;
            if(temp >= 0){
                res += map[temp];
            }
            map[sum]++;
        }
        return res;
    }
}

