package Array;

import java.util.*;

public class _5268 {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> repo1 = new HashSet<>();
        Set<Integer> repo2 = new HashSet<>();
        Set<Integer> res1 = new HashSet<>();
        Set<Integer> res2 = new HashSet<>();

        for (int n : nums1){
            repo1.add(n);
        }

        for(int n : nums2){
            repo2.add(n);
            if(!repo1.contains(n)){
                res2.add(n);
            }
        }

        for (int n : repo1){
            if (!repo2.contains(n)){
                res1.add(n);
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>(res1));
        res.add(new ArrayList<>(res2));
        return res;
    }
}
