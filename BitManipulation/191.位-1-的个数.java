package BitManipulation;
/*
 * @lc app=leetcode.cn id=191 lang=java
 *
 * [191] 位1的个数
 * 在Java中统计二进制形式有几个1有专门的库函数， 在这题里正好可以使用
 */

// @lc code=start
class Solution {
    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}
// @lc code=end

