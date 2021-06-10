package Hash;
import java.util.HashSet;
import java.util.Set;

/**
 * 本题虽然同时使用了动态规划和哈希表, 但其实非常简单
 * 我觉得在本题中哈希表的思路更加重要, 而前缀和的使用是非常自然应该想到的
 */
public class leetcode_523 {
    // 暴力法显然超时
    // public static boolean checkSubarraySum(int[] nums, int k) {
    //     int len = nums.length;
    //     int pre = nums[0];
    //     int sum = pre;
    //     Set<Integer> set = new HashSet<>();
    //     set.add(0);
    //     for(int i = 1; i < len; i++){
    //         sum += nums[i];
    //         for(int n : set){
    //             if((sum - n) % k == 0)return true;
    //         }
    //         set.add(pre);
    //         pre = sum;
    //     }
    //     return false;
    // }

    // K的值可能非常大, 超内存限制了
    // public static boolean checkSubarraySum(int[] nums, int k) {
    //     int len = nums.length;
    //     int pre = nums[0];
    //     int sum = pre;
    //     boolean[] checkTable = new boolean[k];
    //     checkTable[0] = true;
    //     for(int i = 1; i < len; i++){
    //         sum += nums[i];
    //         if(checkTable[sum % k])return true;
    //         checkTable[pre % k] = true;
    //         pre = sum;
    //     }
    //     return false;
    // }


    public static boolean checkSubarraySum(int[] nums, int k) {
        int len = nums.length;
        int pre = nums[0];
        int sum = pre;
        Set<Integer> set = new HashSet<>();
        set.add(0);
        for(int i = 1; i < len; i++){
            sum += nums[i];
            // 只要对k取余的值相等, 那么两个数的差就一定是k的倍数
            if(set.contains(sum % k))return true;
            set.add(pre % k);
            pre = sum;
        }
        return false;
    }
    
    public static void main(String[] args) {
        int[] nums = {23,2,4,6,7};
        boolean res = checkSubarraySum(nums, 10);
        System.out.println(res);
    }
}
