package Array;


/**
 * leetcode_27
 * 删除数组中指定的元素
 */
class leetcode_27 {

    //implement functionality
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

    //pring array
    public static void printArray(int[] nums, int len){
        for(int i = 0; i < len; i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int len = removeElement(nums, 2);
        printArray(nums, len);
    }
}