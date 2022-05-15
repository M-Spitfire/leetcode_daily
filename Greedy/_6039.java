package Greedy;

import org.junit.Test;

import java.util.PriorityQueue;

public class _6039 {
    private final int base = 1000000007;
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int n : nums){
            queue.add(n);
        }

        for (int i = 0; i < k; i++){
            int t = queue.poll();
            queue.add(t + 1);
        }

        long res = 1;
        for (int n : queue){
            res = (res * n) %  base;
        }
        return (int) res;
    }

    @Test
    public void test(){
        int[] nums = {0,4,545,445,144,2,758};
        System.out.println(maximumProduct(nums, 5777));
    }
}
