package DP;
import java.util.HashMap;
import java.util.Map;

/**
 * leetcode_1074
 * 前缀和的题目, 这题的核心思路与363完全相同, 可以参考一下
 */
public class _1074_NumberOfSubmatricesThatSumToTarget {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int res = 0;

        for(int i = 0; i < n; i++){ // top edge
            int nums[] = new int[m];
            for(int j = i; j < n; j++){ // bottom edge
                for(int k = 0; k < m; k++){
                    nums[k] += matrix[j][k];
                }
                /**
                 * 下面就是利用前缀和寻找部分和的过程了
                 */
                Map<Integer, Integer> hashTable = new HashMap<>();
                hashTable.put(0, 1);
                int pre = 0;
                for(int k = 0; k < m; k++){
                    pre += nums[k];
                    Integer count = hashTable.getOrDefault(pre - target, 0);
                    res += count;

                    hashTable.put(pre, hashTable.getOrDefault(pre, 0) + 1);
                }
            }
        }

        return res;
    }
}