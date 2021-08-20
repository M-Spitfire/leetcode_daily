package TwoPointers;

public class _541_ReverseString_II {
    public String reverseStr(String s, int k) {
        if(k == 1)return s;

        char[] chs = s.toCharArray();
        int len = chs.length;

        int step = 2 * k;
        int left = 0;
        int right = 0;
        while(left < len){
            right = Math.min(left + k, len);
            reverse(left, right - 1, chs);
            left += step;
        }

        return new String(chs);
    }

    public void reverse(int left, int right, char[] chs){
        char t;
        while(left < right){
            t = chs[left];
            chs[left] = chs[right];
            chs[right] = t;

            left++;
            right--;
        }
    }
}
