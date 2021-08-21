package String;

import org.junit.Test;

public class _443_StringCompression {
    public int compress(char[] chars) {
        int len = chars.length;
        if(len == 1)return 1;

        char pre = 0;//给一个不会出现在原数组中的字符
        int count = 0;
        int writeIndex = 0;
        int index = 0;
        while(index < len){
            if(index == 0){
                pre = chars[index];
                count++;
            }
            else{
                if(pre == chars[index]){
                    count++;
                }
                else {
                    chars[writeIndex++] = pre;
                    writeIndex = writeNum(writeIndex, count, chars);
                    pre = chars[index];
                    count = 1;
                }
            }
            index++;
        }

        //留着一个尾巴
        chars[writeIndex++] = pre;
        writeIndex = writeNum(writeIndex, count, chars);

        return writeIndex;
    }

    //题目规定字符储量不会超过2000
    public int writeNum(int start, int num, char[] chars){
        //如果该字母只有一个，那么不必写入数量
        if(num == 1)return start;

        boolean flag = false;
        for(int base = 1000; base > 0; base /= 10){
            int temp = num / base;
            if((!flag && temp > 0) || (flag && temp >= 0)){
                chars[start++] = (char) ('0' + temp);
                num %= base;
                flag = true;
            }
        }

        return start;
    }

    @Test
    public void test(){
        char[] chars = {'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o'};
        System.out.println(compress(chars));
    }
}
