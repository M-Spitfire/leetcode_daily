package Greedy;

import org.junit.Test;

/**
 * 这题能用贪心的原因：
 * 如果第i个和第i+1个数相同，
 *      1.当i是奇数时，符合要求，不做改动
 *      2.当i是偶数时，需要删除第j（j <= i + 1）位的数使得这整个序列数符合要求
 *          2.1 删除第j位后最好的结果就是符合要求，总共只需删除1个数
 *          2.2 其他情况就是使得序列其他部分不符合要求，需要额外删除若干个数
*       3.可以发现，想要使得当前序列符合要求，最好的结果就是删除一个数，那么我们选择第i个数或者第i+1个数就好了
 */
public class _5236 {
    public int minDeletion(int[] nums) {
        int len = nums.length;
        int res = 0;
        int index = 0;

        while (index < len){
            int next = findNext(nums, index);
            res += next - index - 1;
            index = next + 1;
        }

        if ((len - res) % 2 == 1)res += 1;
        return res;
    }

    private int findNext(int[] nums, int index) {
        int len = nums.length;
        for(int i = index + 1; i < len; i++){
            if (nums[i] != nums[index]){
                return i;
            }
        }
        return len;
    }

    @Test
    public void test(){
        int[] data = new int[]{2,6,2,5,8,9,7,2,2,5,6,2,2,0,6,8,7,3,9,2,1,1,3,2,6,2,4,6,5,8,4,8,7,0,4,8,7,8,4,1,1,4,0,1,5,7,7,5,9,7,5,5,8,6,4,3,6,5,1,6,7,6,9,9,6,8,6,0,9,5,6,7,6,9,5,5,7,3,0,0,5,5,4,8,3,9,3,4,1,7,9,3,1,8,8,9,1,6,0,0};
        System.out.println(minDeletion(data));
    }
}
