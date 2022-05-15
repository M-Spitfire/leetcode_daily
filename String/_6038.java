package String;

import java.util.ArrayList;
import java.util.List;

public class _6038 {
    public String minimizeResult(String expression) {
        String[] nums = expression.split("\\+");
        char[] chs1 = nums[0].toCharArray();
        char[] chs2 = nums[1].toCharArray();
        int len1 = chs1.length;
        int len2 = chs2.length;

        int min = Integer.MAX_VALUE;
        String res = null;
        for (int i = 0; i < len1; i++){
            int n1 = getNum(chs1, 0, i);
            int n2 = getNum(chs1, i, len1);
            for (int j = 1; j < len2; j++){
                int n3 = getNum(chs2, 0, j);
                int n4 = getNum(chs2, j, len2);

                int temp = (n1 == 0 ? 1 : n1) * (n4 == 0 ? 1 : n4) * (n2 + n3);
                if (temp < min){
                    min = temp;
                    res = "(" + n2 + "+" + n3 + ")";
                    if (n1 != 0)res = n1 + res;
                    if (n4 != 0)res = res + n4;
                }
            }
        }
        return res;
    }

    private int getNum(char[] chs, int start, int end){
        int res = 0;
        for (int i = start; i < end; i++){
            res = res * 10 + (chs[i] - '0');
        }
        return res;
    }
}
