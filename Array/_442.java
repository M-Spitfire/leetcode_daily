package Array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();

        int len = nums.length;
        int t;
        for (int i = 0; i < len; i++){
            while (nums[i] != i + 1){
                t = nums[nums[i] - 1];
                if (t == nums[i])break;
                nums[nums[i] - 1] = nums[i];
                nums[i] = t;
            }
        }
        for (int i = 0; i < len; i++){
            if (nums[i] != i + 1){
                res.add(nums[i]);
            }
        }
        return res;
    }

    @Test
    public void test(){
        int[] arr = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(arr));
    }
}
