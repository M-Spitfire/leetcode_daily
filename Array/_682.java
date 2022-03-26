package Array;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class _682 {
    public int calPoints(String[] ops) {
        int len = ops.length;
        int[] recode = new int[len];
        int index = 0;
        int res = 0;

        for(String str : ops){
            if("+".equals(str)){
                recode[index] = recode[index - 1] + recode[index - 2];
                res += recode[index++];
            }
            else if("D".equals(str)){
                recode[index] = 2 * recode[index - 1];
                res += recode[index++];

            }
            else if("C".equals(str)){
                index--;
                res -= recode[index];
            }
            else {
                recode[index] = Integer.parseInt(str);
                res += recode[index++];
            }
        }

        return res;
    }

    @Test
    public void test(){
        String[] ops = {"5","-2","4","C","D","9","+","+"};
        System.out.println(calPoints(ops));
    }
}
