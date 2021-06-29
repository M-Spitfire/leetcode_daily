package Math;

/**
 * 这题实际上就是26进制数的转换
 * 但是要注意的是, 这个进制没有0, 因此在得到0的时候的处理相对其他数来说要特殊一些
 */

// @lc code=start
class Solution {
    static char[] chs = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    public static String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while(columnNumber > 0){
            if(columnNumber % 26 == 0){
                sb.insert(0, 'Z');
                columnNumber = columnNumber / 26 - 1;
            }
            else{
                int index = (columnNumber % 26) - 1;
                if(index == -1)index = 25;
                sb.insert(0, chs[index]);
                columnNumber /= 26;
            }
            
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String res = convertToTitle(701);
        System.out.println(res);
    }
}
// @lc code=end

