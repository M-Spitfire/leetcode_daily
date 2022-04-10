package Hash;

import org.junit.Test;

import java.util.*;

/**
 * 举个简单的小例子：1, 2, 4, 8
 * 可以发现，如果从2或者4开始验证，可能剩余2和8，原本符合要求的四个数就被判定成不符合要求了
 * 我们可以从1开始验证，找到1*2=2，然后验证4，找到48*2=8，符合要求
 * 也可以从8开始验证，找到8/2=4，然后验证2，找到2/2=1，符合要求
 * 因此我们一定要从一个有序数列的端点开始验证
 *
 * 考虑到可能出现负数，因此这个“有序”应当按照绝对值来排序
 */
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
