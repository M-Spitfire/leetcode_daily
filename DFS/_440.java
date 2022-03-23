package DFS;

import org.junit.Test;

import java.util.Currency;

public class _440 {
    /**
     * 初步思路是DFS
     * 经验证，DFS不管怎么样都是会超时的，所以还是要直接计算出来，不能一个一个遍历
     * - 规定范围的参数n比较大，在DFS的时候会乘以10，要注意处理超出int表示范围，或者使用long
     * ******************************************************************************
     *
     * @param n 数字的范围是1~n
     * @param k 第k"小"的值需要被返回
     */
    public int findKthNumber(int n, int k) {
        int prefix = 1;
        k--; //这里减一我也没想明白，但是下面的过程求出来的结果都是正确结果的后面一个数

        while (k > 0){
            int nums = getNums(prefix, n);
            if(nums <= k){
                k -= nums;
                prefix++;
            }
            else {
                k--;    //相当于这一次只能排除prefix
                prefix *= 10;
            }
        }

        return prefix;
    }

    /**
     * 计算前缀prefix下一共有多少个节点
     */
    private int getNums(int prefix, int n) {
        int res = 0;
        long left = prefix;
        long right = prefix;

        while (left <= n){
            res += Math.min(right, n) - left + 1;
             left *= 10;
             right = right * 10 + 9;
        }

        return res;
    }

    @Test
    public void test(){
        System.out.println(findKthNumber(13, 10));
    }
}
