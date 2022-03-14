package Hash;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _599_MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int minSumOfIndex = 20000;
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < list1.length; i++){
            map.put(list1[i], i);
        }

        for(int i = 0; i < list2.length; i++){
            Integer index1 = map.get(list2[i]);
            if(index1 == null)continue;

            int temp = i + index1;
            if(temp == minSumOfIndex){
                res.add(list2[i]);
            }
            else if (temp < minSumOfIndex){
                minSumOfIndex = temp;
                res.clear();
                res.add(list2[i]);
            }
        }

        return res.toArray(new String[0]);
    }
}
