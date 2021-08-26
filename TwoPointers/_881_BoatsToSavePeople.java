package TwoPointers;

import java.util.Arrays;

public class _881_BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        int res = 0;
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;

        while (left <= right){
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            res++;
        }
        return res;
    }
}
