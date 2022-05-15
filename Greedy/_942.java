package Greedy;

public class _942 {
    public int[] diStringMatch(String s) {
        char[] chs = s.toCharArray();
        int len = chs.length;
        int[] res = new int[len + 1];
        int left = 0;
        int right = len;

        for (int i = 1; i <= len; i++){
            if (chs[i - 1] == 'I'){
                res[i - 1] = left++;
            }
            else res[i - 1] = right--;
        }
        res[len] = left;
        return res;
    }
}
