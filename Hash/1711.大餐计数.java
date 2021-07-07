package Hash;

/*
 * @lc app=leetcode.cn id=1711 lang=java
 *
 * [1711] 大餐计数
 * 
 * 使用哈希表记录各个美味值的菜的数量, 然后计数即可
 * 下面的写法使用数组作为哈希表, 当然也可以使用Map作为哈希表
 * 数组使用更多的空间, 但是速度上会快很多, Map则是空间上更加节省而速度慢一些
 */

// @lc code=start
class Solution {
    public static int countPairs(int[] deliciousness) {
        final int MOD = 1000000007;
        int maxVal = 0;
        int minVal = Integer.MAX_VALUE;
        for (int val : deliciousness) {
            maxVal = Math.max(maxVal, val);
            minVal = Math.min(minVal, val);
        }
        int pairs = 0;
        int[] map = new int[maxVal + 1];
        int n = deliciousness.length;
        for (int i = 0; i < n; i++) {
            int val = deliciousness[i];
            /**
             * 这里只需要考虑已经加入map的菜
             * 因为按顺序加入map, 所以没办法考虑还没有加入map的菜
             */
            for (int sum = 1; ; sum <<= 1) {
                int target = sum - val;
                if(target < minVal)continue;
                if(target > maxVal)break;
                pairs = (pairs + map[target]) % MOD;
            }
            map[val]++;
        }
        return pairs;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,7,9,8,7,6,5,4,3,2};
        int res = countPairs(nums);
        System.out.println(res);
    }
}
// @lc code=end

