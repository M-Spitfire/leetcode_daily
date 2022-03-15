package DFS;

import org.junit.Test;

public class _2044_CountNumberofMaximumBitwiseORSubsets {
    //题目描述很容易让人往位运算上想，虽然能做，但我觉得还是搜索更加简单直接
    int res = 0;
    int count = 0;
    public int countMaxOrSubsets(int[] nums) {
        search(nums, 0, 0);
        return count;
    }

    private void search(int[] nums, int index, int preRes){
        //递归的出口
        if(index == nums.length){
            if(preRes > res){
                res = preRes;
                count = 1;
            }
            else if (preRes == res){
                count += 1;
            }

            return;
        }

        // 选择当前数字
        search(nums, index + 1, preRes | nums[index]);
        // 不选当前数字
        search(nums, index + 1, preRes);
    }

    @Test
    public void test(){
        int[] nums = {3,1};
        int out = countMaxOrSubsets(nums);
        System.out.println(out);
    }
}
