package Array;

import java.util.*;

public class _6037 {
    public int largestInteger(int num) {
        PriorityQueue<Integer> odd = new PriorityQueue<>();
        PriorityQueue<Integer> even = new PriorityQueue<>();
        List<Boolean> isOdd = new ArrayList<>();

        while (num != 0){
            int t = num % 10;
            num = num / 10;

            if (t % 2 == 0){
                even.add(t);
                isOdd.add(false);
            }
            else{
                odd.add(t);
                isOdd.add(true);
            }
        }

        int res = 0;
        int base = 1;
        for (Boolean b : isOdd){
            if (b){
                res += base * odd.poll();
            }
            else res += base * even.poll();
            base *= 10;
        }
        return res;
    }
}
