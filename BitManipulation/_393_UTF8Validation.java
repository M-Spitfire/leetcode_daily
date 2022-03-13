package BitManipulation;

import org.junit.Test;

public class _393_UTF8Validation {
    //取出每个字节的信息位的位运算都是一样的，可以写在外面
    private static int bit1 = 1 << 7;
    private static int bit2 = (1 << 7) + (1 << 6);

    //根据题目给出的规则判定即可
    //本体的关键在于如何取出当前字节的有用信息，位运算是最合适的
    public boolean validUtf8(int[] data) {
        int len = data.length;

        for(int i = 0; i < len; ){
            int temp = data[i];
            int count = getCount(temp);

            /*
            wc，这个地方没考虑到
            有可能首字节表明后面还有字节，但是给定的数组没有数据了，这会导致数组越界
             */
            if(count < 0 || i + count > len)return false;
            else if(count == 1){
                i++;
                continue;
            }
            for(int j = 1; j < count; j++){
                if(!check(data[i + j]))
                    return false;
            }
            i += count;
        }
        return true;
    }

    //获取字符首字节中的信息
    private int getCount(int num) {
        //首位是1，单字节即可表示该字符
        if(0 == (bit1 & num)){
            return 1;
        }
        int count = 1;
        //从左到右扫描int的最后一个字节，数连续1的个数
        int tempBit = bit1 >> 1;
        while(tempBit != 0){
            if(0 == (tempBit & num)){
                break;
            }
            count++;
            tempBit = tempBit >> 1;
        }

        //10作为首位的字节不能是首字节
        //单个字符的字节数不会超过4
        if(count < 2 || count > 4){
            return -1;
        }
        return count;
    }

    //校验是否以10开头
    private boolean check(int n){
//        128就是10000000，实际上也是上面定义的bit1
//        return 128 == (n & bit2);
        return bit1 == (n & bit2);
    }

    @Test
    public void test(){
        int[] data = {197, 130, 1};
        System.out.println(validUtf8(data));
    }
}
