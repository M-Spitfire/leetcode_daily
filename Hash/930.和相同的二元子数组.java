package Hash;

/*
 * @lc app=leetcode.cn id=930 lang=java
 *
 * [930] 和相同的二元子数组
 * 
 * 滑动窗口更快, 但是没有哈希表来的简单直观
 */

// @lc code=start
class Solution {
    public static int numSubarraysWithSum(int[] nums, int goal) {
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

    public static void main(String[] args) {
        int[] nums = {0,0,0,0,0};
        int res = numSubarraysWithSum(nums, 0);
        System.out.println(res);
    }
}
// @lc code=end

