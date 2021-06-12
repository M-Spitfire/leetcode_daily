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

    /**
     * 由于没法知道定义在父类VersionControl中的方法isBadVersion的具体实现
     * 所以这里取消继承VersionControl, 并写一个无意义的同名方法消除报错
     * [WARN]:
     * 如果使用vscode写, 不要再写下面这个方法了, 忍受一下红线直接提交吧
     * 如果你和我一样无法接受红线出现在没有问题的代码里, 那就写一个下面的函数, 但是提交就要把上面的代码复制到网页上去提交了
     */
    public boolean isBadVersion(int n){
        return true;
    }
}
// @lc code=end

