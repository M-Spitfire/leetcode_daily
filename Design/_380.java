package Design;

import java.util.*;

public class _380 {
    class RandomizedSet {
        private Map<Integer, Integer> repo;
        private List<Integer> valList;

        public RandomizedSet() {
            repo = new HashMap<>();
            valList = new ArrayList<>();
        }

        public boolean insert(int val) {
            if (repo.containsKey(val))return false;
            valList.add(val);
            return repo.put(val, val) == null;
        }

        public boolean remove(int val) {
            if (!repo.containsKey(val))return false;
            valList.remove(Integer.valueOf(val));
            return repo.remove(val, val);
        }

        public int getRandom() {
            int index = valList.get((int) (Math.random() * repo.size()));
            return repo.get(index);
        }
    }

}
