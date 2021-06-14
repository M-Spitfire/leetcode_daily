package BinarySearch;

/*
 * @lc app=leetcode.cn id=374 lang=java
 *
 * [374] 猜数字大小
 */

// @lc code=start
/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

class Solution{
    public int guessNumber(int n) {
        int left = 1, right = n;
        while(left < right){
            int mid = left + (right - left) / 2;
            int t = guess(mid);
            if(t == 0)return mid;
            else if(t == 1)left = mid + 1;
            else right = mid;
        }
        return left;
    }

    // 防止报错的无意义的函数
    public int guess(int n){
        return 0;
    }
}
// @lc code=end

