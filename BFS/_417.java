package BFS;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.DelayQueue;

public class _417 {
    int[][] steps = {{1,0},{0,1},{-1,0},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;;
        int n = heights[0].length;
        int[][] flag = new int[m][n];

        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();
        //BFS标记所有能从左边界和上边界流出的点
        flag[0][0] = 1;
        queue.add(0);
        queue.add(0);
        while (!queue.isEmpty()){
            int size = queue.size() / 2;
            for (int i = 0; i < size; i++){
                int x = queue.poll();
                int y = queue.poll();
//                flag[x][y] = 1;
                for(int[] step : steps){
                    int a = x + step[0];
                    int b = y + step[1];
                    if (a < 0 || a >= m || b < 0 || b >= n || flag[a][b] != 0)continue;

                    if (heights[a][b] >= heights[x][y] || b == 0 || a == 0){
                        flag[a][b] = 1;
                        queue.add(a);
                        queue.add(b);
                    }
                }
            }
        }

        //BFS标记所有能从右边界和下边界流出的点
        if (flag[m - 1][n - 1] == 1)res.add(Arrays.asList(m - 1, n - 1));
        flag[m - 1][n - 1] = 2;
        queue.add(m - 1);
        queue.add(n - 1);
        while (!queue.isEmpty()){
            int size = queue.size() / 2;
            for (int i = 0; i < size; i++){
                int x = queue.poll();
                int y = queue.poll();
//                if (flag[x][y] == 2)res.add(Arrays.asList(x, y));
                for(int[] step : steps){
                    int a = x + step[0];
                    int b = y + step[1];
                    if (a < 0 || a >= m || b < 0 || b >= n || flag[a][b] == 2)continue;

                    if (heights[a][b] >= heights[x][y] || a == m - 1 || b == n - 1){
                        if (flag[a][b] == 1){
                            res.add(Arrays.asList(a, b));
                        }
                        flag[a][b] = 2;
                        queue.add(a);
                        queue.add(b);
                    }
                }
            }
        }
        return res;
    }

    @Test
    public void test(){
        int[][] height = {{2,1},{1,2}};
        System.out.println(pacificAtlantic(height));
    }
}
