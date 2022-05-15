package DP;

import org.junit.Test;

public class _396 {
    public int maxRotateFunction(int[] nums) {
        int res = 0;
        int sum = 0;
        int len = nums.length;
        for(int i = 0; i < len; i++){
            res += i * nums[i];
            sum += nums[i];
        }
        int pre = res;
        for (int i = 0; i < len - 1; i++){
            pre = pre - sum + nums[i] + nums[i] * (len - 1);
            if(pre > res){
                res = pre;
            }
        }
        return res;
    }

    @Test
    public void test(){
        int[] nums = {4,3,2,6,-4};
        System.out.println(maxRotateFunction(nums));
    }
}
