package Array;

import java.util.Arrays;

public class _6064 {
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int len = special.length;
        int res = 0;
        for (int i = 1; i < len; i++){
            res = Math.max(res, special[i] - special[i - 1] - 1);
        }
        res = Math.max(res, special[0] - bottom);
        res = Math.max(res, top - special[len - 1]);
        return res;
    }
}
