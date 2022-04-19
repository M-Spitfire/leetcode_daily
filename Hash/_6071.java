package Hash;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class _6071 {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> count = new HashMap<>();
        int res = 0;
        for (int level : tasks){
            count.put(level, count.getOrDefault(level, 0) + 1);
        }

        for (int level : count.keySet()){
            int num = count.get(level);
            res += num / 3;
            int left = num % 3;
            if (left == 0)continue;
            if (left == 2)res++;
            else {
                if (num > 3)res++;
                else return -1;
            }
        }
        return res;
    }

    @Test
    public void test(){
        int[] tasks = {2,2,3,3,2,4,4,4,4,4};
        System.out.println(minimumRounds(tasks));
    }
}
