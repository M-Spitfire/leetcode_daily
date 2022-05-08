package String;

import org.junit.Test;

public class _6056 {
    public String largestGoodInteger(String num) {
        char[] chs = num.toCharArray();
        int len = chs.length;
        Integer res = -1;
        for (int i = 2; i < len; i++){
            if (chs[i] == chs[i - 1] && chs[i] == chs[i - 2]){
                int t = 100 * (chs[i - 2] - '0') + 10 * (chs[i - 1] - '0') + chs[i] - '0';
                if (t > res){
                    res = t;
                }
            }
        }
        if (res == -1)return "";
        else if (res == 0)return "000";
        else return res.toString();
    }
    @Test
    public void test(){
        System.out.println(largestGoodInteger("42352338"));
    }
}
