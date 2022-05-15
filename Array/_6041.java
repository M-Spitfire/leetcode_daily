package Array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _6041 {
    public List<Integer> intersection(int[][] nums) {
        int[] record = new int[1001];
        int count = 0;

        for(int[] num : nums){
            for (int n : num){
                record[n]++;
                if (record[n] == nums.length){
                    count++;
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 1001; i++){
            if (record[i] == nums.length){
                res.add(i);
            }
        }

        return res;
    }
}
