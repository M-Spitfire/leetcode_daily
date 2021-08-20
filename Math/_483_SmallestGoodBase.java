package Math;
/*
 * @lc app=leetcode.cn id=483 lang=java
 *
 * [483] 最小好进制
 * 数学题，这题数学不好时间复杂度不可能低
 * 我数学不好...
 */

/**
 * 用二进制举个例子：
 * 7 = 2^0 + 2^1 + 2^2
 * 若十进制数n在k进制下有m + 1为，且每一位都为1，那么显然有：
 * ①：n = k^0 + k^1 + ... + k^m
 * 上面这个等式是我们进行验证的方式
 * 
 * 有了上面的验证方式， 我们就可以通过枚举的方式找到真正的答案，但枚举的效率显然不够高
 * 有没有方法将范围缩小一些呢
 * 1. 
 *      将①式的右边看成等比数列求和，得到n = (1 - k^(m+1)) / (1 - k)
 *      化简一下：k^(m+1) = n * (k - 1) + 1 < n * k （题目保证n >= 3）
 *      两边取对数（以k为底）：m + 1 < 1 + log(n) 
 *      => m < log(n)（以k为底）
 * 2. 
 *      由二项式定理展开 (k + 1)^m后发现，与①式右边的不同之处只有系数
 *      由此我们可以得到 k^m < n < (k + 1)^m
 *      开根号可得： k < n^(1/m) < k+1
 *      由于k代表的是进制数，因此必为正整数，因此n^(1/m)为小数，且k是它的整数部分
 * 由结论1我们可以快速缩小m的取值范围，从最大的m开始依次向下取，每一次都利用结论快速求出k，然后进行验证
 * 如果验证成功，直接返回k，如果所有都不行，返回n - 1(n在n-1进制下的表示为11，必定正确，但题目要求进制数尽量小)
 */

public class _483_SmallestGoodBase {
    public String smallestGoodBase(String n) {
        long realN = Long.parseLong(n);
        //最小进制为2。用了一下换底公式
        int maxM = (int)Math.floor(Math.log(realN) / Math.log(2));
        for(int i = maxM; i > 1; i--){
            int k = (int)Math.pow(realN, 1.0 / i);
            long res = 1;
            long t = 1;
            for(int j = 0; j < i; j++){
                t *= k;
                res += t;
            }
            if(res == realN)return Integer.toString(k);
        }
        return Long.toString(realN - 1);
    }
}

