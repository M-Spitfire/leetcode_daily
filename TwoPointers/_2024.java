package TwoPointers;

public class _2024 {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        char[] chs = answerKey.toCharArray();
        int len = chs.length;
        int left = 0;
        int right = 0;
        int min = 0;
        int[] count = new int[2];
        int res = 0;

        while (right < len){
            if (chs[right] == 'T')count[0]++;
            else count[1]++;
            right++;

            min = Math.min(count[0], count[1]);
            while (min > k){
                if (chs[left] == 'T')count[0]--;
                else    count[1]--;
                left++;
                min = Math.min(count[0], count[1]);
            }

            res = Math.max(res, right - left);
        }

        return res;
    }
}
