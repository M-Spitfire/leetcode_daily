package BitManipulation;

/**
 * 剑指15.二进制中1的个数
 * 有意思的小题目,与191题完全相同
 */
public class _15_offer_NumberOf1Bits {
    public static int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}