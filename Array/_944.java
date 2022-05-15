package Array;

public class _944 {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        boolean[] flags = new boolean[m];
        char[] prev = strs[0].toCharArray();

        for (int i = 1; i < n; i++){
            char[] back = strs[i].toCharArray();
            for (int j = 0; j < m; j++){
                flags[j] = flags[j] || prev[j] > back[j];
            }
            prev = back;
        }

        int res = 0;
        for (boolean flag : flags){
            if (flag)res++;
        }
        return res;
    }
}
