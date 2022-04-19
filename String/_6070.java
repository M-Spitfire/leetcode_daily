package String;

import org.junit.Test;

public class _6070 {
    public String digitSum(String s, int k) {
        if (s.length() <= k)return s;

        char[] chs = s.toCharArray();
        int len = chs.length;
        int count = 1;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < len; ){
            int limit = Math.min(len, i + k);
            int tmp = 0;
            int j = i;
            for (; j < limit; j++){
                tmp += chs[j] - '0';
            }
            i = j;
            sb.append(tmp);
        }

        return digitSum(sb.toString(), k);
    }

    @Test
    public void test(){
        String s = "11111222223";
        System.out.println(digitSum(s, 3));
    }
}
