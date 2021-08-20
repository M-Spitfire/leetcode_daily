package DP;

/**
 * 这个题目实际上是一个斐波那契数列, 只是稍微加了一点约束条件
 * 当然也可以看成是动态规划的思路
 */

public class _91_DecodeWays {
    public int numberDecoding(String s){
        char[] chs = s.toCharArray();
        int pre = 0;
        int res = 1;
        int temp = 0;

        for(int i = 0; i < chs.length; i++){
            temp = 0;

            //当成一位数字
            if(chs[i] != '0')temp += res;

            //当成二位数字的后一位
            if(i == 0 || chs[i - 1] == '1' ||
                    (chs[i] >= '0' && chs[i] <= '6' && chs[i - 1] == '2')){
                temp += pre;
            }

            //如果当前位的结果为0, 说明没有办法解码当前位, 直接返回0
            //实际上这种情况只会出现在最前面, 比如00, 02, 67, 这些情况如果不出现在最前面, 至少能有一种方式解码
            if(temp == 0)return 0;
            else{
                pre = res;
                res = temp;
            }
            System.out.println(pre + " " + res);
        }

        return res;
    }
}
