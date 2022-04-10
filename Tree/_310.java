package Tree;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 1){
            res.add(0);
            return res;
        }
        ArrayList<Integer>[] map = new ArrayList[n];
        int[] degree = new int[n];
        for (int[] edge : edges){
            if (map[edge[0]] == null){
                map[edge[0]] = new ArrayList<>();
            }
            if (map[edge[1]] == null){
                map[edge[1]] = new ArrayList<>();
            }
            map[edge[0]].add(edge[1]);
            map[edge[1]].add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++){
            if (degree[i] == 1){
                deque.add(i);
            }
        }

        while (!deque.isEmpty()){
            res.clear();
            int len = deque.size();
            for (int i = 0; i < len; i++){
                int root = deque.pollFirst();
                for (int child : map[root]){
                    degree[child]--;
                    if (degree[child] == 1){
                        deque.add(child);
                    }
                }
                res.add(root);
            }
        }

        return res;
    }

    @Test
    public void test(){
        int[][] edges = {
                {1,0},
                {1,2},
                {1,3}
        };
        System.out.println(findMinHeightTrees(4, edges));
    }
}
