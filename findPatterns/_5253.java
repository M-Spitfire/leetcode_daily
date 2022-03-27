package findPatterns;

import org.junit.Test;

import java.util.*;

/**
 * 遍历所有数去验证是否是回文数是会超时的，因此这里我们直接从小到大构造回文数
 *
 * 根据回文数的特点，可以只考虑前面一半，比如说第1个5位回文数是10001
 * 我们可以只考虑100，后面的两位反转就可得到
 *
 * 这里还有一个规律：
 * 第1个5位回文数的前一半是100
 * 第2个5位回文数的前一半是101
 * ...
 * 第100个5位回文数的前一半是199
 * ...
 */
public class _5253 {

    public long[] kthPalindrome(int[] queries, int intLength) {
        long base = (long) Math.pow(10, (intLength + 1) / 2 - 1);
        long limit = 9 * base;
        long[] res = new long[queries.length];

        for (int i = 0; i < queries.length; i++){
            if (queries[i] > limit)res[i] = -1;
            else res[i] = getResult(base + queries[i] - 1, intLength);
        }

        return res;
    }

    private long getResult(long base,  int len) {
        char[] chs = new char[len];
        int left = (len - 1) / 2;
        int right = left;

        if (len % 2 == 0){
            right = left + 1;
        }

        while (base != 0){
            int t = (int) (base % 10);
            base = base / 10;
            chs[left] = (char)('0' + t);
            chs[right] = chs[left];
            left--;
            right++;
        }

        return Long.parseLong(String.valueOf(chs));
    }

    @Test
    public void test(){
        int[] data = new int[]{2,4,6};
        long[] res = kthPalindrome(data, 4);
        System.out.println(Arrays.toString(res));
    }
}
