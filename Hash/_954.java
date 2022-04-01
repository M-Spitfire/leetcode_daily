package Hash;

import org.junit.Test;

import java.util.*;

public class _954 {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : arr){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Integer> keyList = new ArrayList<>(map.keySet());
        keyList.sort(Comparator.comparingInt(Math::abs));

        for (int n : keyList){
            //2 * n可能是原数组中不存在的数
            if (map.getOrDefault(2 * n, 0) < map.get(n))return false;

            map.put(2 * n, map.getOrDefault(2 * n, 0) - map.get(n));
        }

        return true;
    }

    @Test
    public void test(){
        int[] arr = new int[]{2,1,2,1,1,1,2,2};
        System.out.println(canReorderDoubled(arr));
    }
}
