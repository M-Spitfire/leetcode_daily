package BinarySearch;
/*
 * @lc app=leetcode.cn id=278 lang=java
 *
 * [278] 第一个错误的版本
 * 
 * 明显是二分查找题
 */

// @lc code=start
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

class Solution{
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while(left < right){
            // 防止超过int的表示范围
            int mid = left + (right - left) / 2;
            boolean res = isBadVersion(mid);
            if(res)right = mid;
            else{
                left = mid + 1;
            }
        }
        return right;
    }

    // 由于没法知道定义在父类VersionControl中的方法isBadVersion的具体实现
    // 所以这里取消继承VersionControl, 并写一个无意义的同名方法消除报错
    public boolean isBadVersion(int n){
        return true;
    }
}
// @lc code=end

