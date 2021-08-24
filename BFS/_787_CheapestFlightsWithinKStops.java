package BFS;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 这题很明显是图的最短路径问题
 * 限制了搜索次数，最容易想到的显然是广度优先搜索
 * 但是本题有一个更好的算法叫做Bellman Ford算法，利用了动态规划来求最短路径
 * 当然也可以使用迪杰斯特拉，但本题有限制，所以需要进行一些修改
 */
public class _787_CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dis = new int[n];
        int[] temp = new int[n];
        for(int i = 0; i < n; i++){
            dis[i] = Integer.MAX_VALUE / 2;
        }
        dis[src] = 0;
        for(int i = 0; i <= k; i++){
            System.arraycopy(dis, 0, temp, 0, n);
            for(int[] flight : flights){
                dis[flight[1]] = Math.min(dis[flight[1]], temp[flight[0]] + flight[2]);
            }
        }
        return dis[dst] < Integer.MAX_VALUE / 2 ? dis[dst] : -1;
    }

    @Test
    public void test(){
        int[][] flights = {{0,1,100},{1,2,100},{0,2,500}};
        int res = findCheapestPrice(3, flights, 0, 2, 1);
        System.out.println(res);
    }
}
