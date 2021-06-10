package BitManipulation;
/**
 * leetcode_477
 * 
 * 两个整数的汉明距离就是是它们异或的结果中'1'的位数
 * 因此, 本题只需要异或之后统计'1'的位数即可
 * 统计'1'的位数的常用思路:
 * 1. 除二取余法
 * 2. 库函数:Integer.bitCount(int)
 */
class leetcode_477 {

    // 暴力法, 超时
    // public int totalHammingDistance(int[] nums) {
    //     int count = 0;
    //     for(int i = 0; i < nums.length; i++){
    //         for(int j = i + 1; j < nums.length; j++){
    //             count += Integer.bitCount(nums[i] ^ nums[j]);
    //         }
    //     }
    //     return count;
    // }

    /**
     * 题目要求: 统计任意两个数之间的汉明距离的总和
     * 思路: 由于是任意两个数之间的汉明距离的总和, 因此我们可以一位一位的统计
     *      比如说数组中有10个数, 其中有3个数的第一位是1, 其余7个数的第一位是0
     *      那么这10个数第一位的汉明距离的综合就是3 * 7 = 21
     *      一直循环直到统计完所有位即可
     */
    public int totalHammingDistance(int[] nums) {
        int res = 0;
        int len = nums.length;
        for(int i = 0; i < 30; i++){    // 由于题目给定的数字小于2^30, 所以只要检查前29位即可
            int count = 0;
            for(int j = 0; j < len; j++){
                /**
                 * (nums[j] >> i) & 1
                 * 这个操作可以取出nums[j]的第i位数字
                 */
                count += (nums[j] >> i) & 1;
            }
            res += count * (len - count);
        }
        return res;
    }

    public static void main(String[] args) {
    }
}