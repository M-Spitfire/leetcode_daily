package Array;

/**
 * 本题数据量比较大，使用模拟的方式显然是会超时的
 * 这种在某个一区间内修改数据的题目可以使用差分数组
 *
 * 什么是差分数组：
 * origin[1, 3, 2, 5, 8]
 * 上面的数组的差分数组如下：prefix[1, 2, -1, 3, 3]
 *      实际上就是与前一个值的差组成的数组，容易得到下面一条重要结论：
 *      【差分数组的前缀和就是原数组】
 *
 * 差分数组的好处：
 * 在origin中，想要将下标[0, 3]区间的值都增加10
 * 在prefix中，只需要将prefix[0]加10，prefix[4]减10即可
 * 可以看到，不管需要操作的区间多大，差分数组都只需要操作两个位置的值就能完成
 */
public class _1109_CorporateFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] tickets = new int[n];

        for(int[] t : bookings){
            tickets[t[0] - 1] += t[2];
            tickets[t[1] - 1] -= t[2];
        }

        for(int i = 1; i < n; i++){
            tickets[i] += tickets[i - 1];
        }

        return tickets;
    }
}