package Array;

/**
 * 纯正的树状数组题
 *
 * 关于树状数组，需要比较多的基础知识，在这里解释起来比较麻烦，可以通过下面的链接学习一下：
 * https://www.bilibili.com/video/BV1Hz411v7XC?p=2
 */
public class _307 {

    private int[] nums;
    private int[] sum;

    public _307(int[] nums) {
        this.nums = nums;
        this.sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++){
            int index = i + 1;
            while (index < sum.length){
                sum[index] += nums[i];
                index += lowBit(index);
            }
        }
    }

    public void update(int index, int val) {
        int diff = val - nums[index];
        nums[index] = val;
        while (index < sum.length){
            sum[index] += diff;
            index += lowBit(index);
        }
    }

    public int sumRange(int left, int right) {
        return getPreSum(right) - getPreSum(left);
    }

    private int lowBit(int i){
        return i & (-i);
    }

    private int getPreSum(int index){
        int res = 0;
        while (index > 0){
            res += sum[index];
            index -= lowBit(index);
        }
        return res;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
