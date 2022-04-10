package BitManipulation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class _762 {
    private static boolean[] table = new boolean[]{false, false, true, true, false, true, false, true, false, false, false, true, false, true, false, false, false, true, false, true, false, false, false, true, false, false, false, false, false, true, false, true, false};

    public int countPrimeSetBits(int left, int right) {
        int res = 0;
        for (int i = left; i <= right; i++){
            if (table[Integer.bitCount(i)])res++;
        }
        return res;
    }
}
