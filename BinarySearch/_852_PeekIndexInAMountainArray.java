package BinarySearch;

/*
 * @lc app=leetcode.cn id=852 lang=java
 *
 * [852] 山脉数组的峰顶索引
 * 
 * 二分查找题
 * 由于题目给定的数组确定是一个“山脉数组”， 故有且只有一个山峰， 没有“平台”
 * 因此我们只需要验证左边是否一直增大或者右边依次减小就可以了
 */

public class _852_PeekIndexInAMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while(left < right){
            // 题目给定的数组长度不可能越界
            int mid = (left + right) / 2;
            /**
             * 解释一下这里比较的对象是arr[mid + 1]的原因
             * 因为mid的求法是偏向于left的，要不是左右两边的正中间， 要不是最中间两个偏向left的那一个
             * 因此mid的右边一定还有一个合法的mid + 1
             */
            if(arr[mid] > arr[mid + 1]){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        return left;
    }
}

