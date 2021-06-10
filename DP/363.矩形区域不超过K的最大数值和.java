package DP;
import java.util.TreeSet;

/**
 * leetcode_363
 * 1. 确认上下边界
 * 2. 上下边界之间的二维数组可以看成一个一维数组, 
 *      问题也就退化成了:
 *      在一维数组中寻找一个连续的序列(长度至少为1), 使序列中的数字的和(记为ans)最大且ans <= k
 *      这实际上就是转化成一维数组前缀和的问题, 这是最简单的动态规划了
 */
class leetcode_363 {

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int ans = Integer.MIN_VALUE;
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i = 0; i < m; i++){//确定上边界
            int sum[] = new int[n];
            for(int j = i; j < m; j++){//确定下边界
                for(int l = 0; l < n; l++){
                    sum[l] += matrix[j][l];
                }
                TreeSet<Integer> numSet = new TreeSet<>();
                numSet.add(0);
                int temp = 0;
                for(int num : sum){
                    temp += num;
                    Integer ceil = numSet.ceiling(temp - k);
                    if(ceil != null){
                        ans = Math.max(ans, temp - ceil);
                    }
                    numSet.add(temp);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        
    }
}