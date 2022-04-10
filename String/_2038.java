package String;

import org.junit.Test;

public class _2038 {
    /**
     删除时A，B颜色同理，这里以A为例：
     1. 删除一个A需要有连续的3个A
     2. 由于删除后至少剩下2个连续的A，所以A的删除不会创造出新的可以删除的B
     */
    public boolean winnerOfGame(String colors) {
        char[] chs = colors.toCharArray();
        int countA = 0;
        int countB = 0;
        char pre = chs[0];
        int count = 1;
        int len = chs.length;

        for(int i = 1; i < len; i++){
            //如果和前一个颜色相同，计数器加一
            if (chs[i] == pre){
                count++;
                if (count > 2){
                    if(pre == 'A')countA += 1;
                    else countB += 1;
                }
            }
            //和前一个颜色不同，清空计数
            else{
                count = 1;
                pre = chs[i];
            }
        }

        return countA > countB;
    }

    @Test
    public void test(){
        System.out.println(winnerOfGame("AAAABBBB"));
    }
}
