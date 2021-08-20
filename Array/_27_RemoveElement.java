package Array;


/**
 * leetcode_27
 * 删除数组中指定的元素
 */
public class _27_RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}