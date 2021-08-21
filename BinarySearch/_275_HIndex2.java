package BinarySearch;
/*
 * @lc app=leetcode.cn id=275 lang=java
 *
 * [275] H 指数 II
 */

public class _275_HIndex2 {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int left = citations[0];
        int right = citations[len - 1];

        while(left < right){
            int mid = left + (right - left) / 2;
        }

        return right;
    }
}

