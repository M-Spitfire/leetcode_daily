package DP;
/**
 * 实际上也是一个简单的前缀和问题, 只是问题的描述看起来复杂而已
 * 结果位true的两个条件:
 *      1. 在favoriteDay当天还有能力吃favoriteType糖果: 
 *          (favoriteDay + 1) * dailyCap > sum{candiesCount[i] | i < favoriteDay}
 *      2. 在favoriteDay当天还有favoriteType糖果:
 *          favoriteDay * 1 < sum{candiesCount[i] | i <= favoriteDay}
 * [注意]:本题的数字会非常大, 不能用int, 要用long
 */

class leetcode_1744 {

    public static boolean[] canEat(int[] candiesCount, int[][] queries) {
        int len = queries.length;
        boolean[] res = new boolean[len];
        int len2 = candiesCount.length;
        long[] candies = new long[len2 + 1];
        // candies[0] = 0;  //使用Long时默认初始化成Null,会造成空指针, 用基本数据类型就不会了
        for(int i = 1; i <= len2; i++){
            candies[i] = candies[i - 1] + candiesCount[i - 1];
        }
        for(int i = 0; i < len; i++){
            int favoriteType = queries[i][0], favoriteDay = queries[i][1], dailyCap = queries[i][2];
            long t1 = (long)(favoriteDay + 1) * dailyCap;
            long t2 = favoriteDay;
            long low = candies[favoriteType];
            long high = candies[favoriteType + 1];
            res[i] = (t1 > low) && (t2 < high);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] candiesCount = {5,2,6,4,1};
        int[][] queries = {
            {3,1,2},
            {4,10,3},
            {3,10,100},
            {4,100,30},
            {1,3,1}
        };
        canEat(candiesCount, queries);
    }

    /**
     * 泛型函数打印数组
     * 接收的数组是Integer, Boolean等引用数据类型, 基本数据类型是不行的, 需要转换
     */
    public static <T> void printArray(T[] array){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}

