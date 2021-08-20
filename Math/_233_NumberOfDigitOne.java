package Math;
/*
 * @lc app=leetcode.cn id=233 lang=java
 *
 * [233] 数字 1 的个数
 */

/**
 * 本题如果使用常规思路对每一个数都进行统计, 必然是会超时的, 所以应该还是需要使用一些数学或者说规律
 * 使用1234来距离, 统计数字1在百位出现的次数
 * - 最明显的规律, 每一千个数[000, 999], 数字1在百位上都会出现一百次[100, 199]
 * - 不满足一千循环的余数t(本例中t就是234), 我们进行分类讨论
 *  - 如果余数t[0, 99], 不需要更改结果
 *  - 如果余数t[100, 199], 结果加上t - 100 + 1
 *  - 如果余数t[199, 999], 结果加上100
 *  - 上面的三种情况可以总结成下面这个式子: ans += min(max(t - 100 + 1, 0), 100)
 * - 其他位的规律与百位大同小异
 */

public class _233_NumberOfDigitOne {
    public int countDigitOne(int n) {
        long base = 1;
        int ans = 0;

        while(base < n){
            ans += n / (base * 10) * base + Math.min(Math.max(n % (base * 10) - base + 1, 0), base);
            base *= 10;
        }

        return ans;
    }
}

