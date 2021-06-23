package BitManipulation;

/**
 * 剑指15.二进制中1的个数
 * 有意思的小题目,与191题完全相同
 */
class Solution {

    public static int hammingWeight(int n) {
        return Integer.bitCount(n);
    }

    public static void main(String[] args) {
        //首位是0的数, Java默认会用八进制来解析
        System.out.println(hammingWeight(00000000000000000000000000001011));
    }
}