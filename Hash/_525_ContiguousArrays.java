package Hash;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * leetcode_525
 * 哈希表, 记录前面的数组种0和1的数量的差, 后面的遍历就能直接查表了
 */
public class _525_ContiguousArrays {
    public int findMaxLength(int[] nums) {
        int res = 0;
        int count0 = 0; //记录0的个数
        int count1 = 0; //记录1的个数
        // key:count0 - count1     value:索引
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0)count0++;
            else count1++;
            int target = count0 - count1;
            Integer t = map.get(target);
            if(t == null){
                map.put(target, i);
            }
            else{
                res = Math.max(res, i - t);
            }
        }
        return res;
    }
}