package DFS;

public class LCP07_传递消息 {
    /**
     求方案的数量, 使用DFS

     使用BFS同样简单, 只要在第三轮遍历的时候停止后续遍历, 并且统计在队列中的n - 1的数量即可

     居然还有动态规划的解法, 这是我没想到的...
     */
    int res = 0;
    int limit = 0;
    boolean[][] map;
    public int numWays(int n, int[][] relation, int k) {
        limit = k;
        map = new boolean[n][n];

        for(int[] t : relation){
            map[t[0]][t[1]] = true;
        }

        search(0, n - 1, 0);

        return res;
    }

    public void search(int now, int target, int step){
        if(step > limit)return;
        if(step == limit && target == now){
            res++;
            return;
        }
        for(int i = 0; i <= target; i++){
            if(map[now][i]){
                search(i, target, step + 1);
            }
        }
    }
}
