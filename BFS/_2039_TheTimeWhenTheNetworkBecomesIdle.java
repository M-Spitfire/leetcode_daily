package BFS;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _2039_TheTimeWhenTheNetworkBecomesIdle {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int len = patience.length;

        //构建邻接表
        List<Integer>[] map = new List[len];
        for (int i = 0; i < len; i++){
            map[i] = new ArrayList<Integer>();
        }
        for(int[] edge : edges){
            //注意是无向图
            map[edge[0]].add(edge[1]);
            map[edge[1]].add(edge[0]);
        }

        //广度优先搜索获得所有节点到0号节点的距离
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(0);
        int distance = 0;
        boolean[] visit = new boolean[len];
        visit[0] = true;
        int res = 0;

        while (!queue.isEmpty()){
            distance += 1;
            int n = queue.size();
            for(int i = 0; i < n; i++){
                int src = queue.removeFirst();
                for (int node : map[src]) {
                    if(visit[node])continue;

                    queue.addLast(node);
                    visit[node] = true;

                    /*
                     * 我们只需要关心：
                     * 当收到0号服务器的回复时，在信道上的最后一个请求的位置
                     * 不需要关心：
                     * 总共重发了多少次
                     */
                    int laji = (2 * distance) % patience[node];
                    if(laji == 0)laji = patience[i];

                    int temp = 4 * distance - laji;
                    res = Math.max(res, temp);
                }
            }
        }

        return res + 1;
    }

    @Test
    public void test(){
        int[][] edges = {
                {0, 1},
                {1, 2}
        };
        int[] patience = {0,2,1};

        System.out.println(networkBecomesIdle(edges, patience));
    }
}
