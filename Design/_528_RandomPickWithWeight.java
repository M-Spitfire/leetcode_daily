package Design;

import java.util.Random;

public class _528_RandomPickWithWeight {
    class Solution {
        int limit;
        int[] data;
        int len;

        public Solution(int[] w) {
            len = w.length;
            data = w;
            limit = w[0];
            data = new int[len];
            data[0] = w[0];
            for(int i = 1; i < len; i++){
                limit += w[i];
                data[i] += data[i - 1] + w[i];
            }
        }

        public int pickIndex() {
            int weight = (int) (Math.random() * limit + 1);

            int left = 0;
            int right = len - 1;
            while(left < right){
                int mid = (left + right) / 2;
                if(data[mid] < weight){
                    left = mid + 1;
                }
                else{
                    right = mid;
                }
            }
            return right;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
}
