package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目给的是有向无环图，这意味着下面两点：
 * 1. 搜索到目标点之后即可将当前搜索顺序添加到结果集中，本条路线不会再次经过目标点
 * 2. 下面代码中的visited数组实际上可以不用，因为无环图
 */
public class _797_AllPathsFromSourceToTarget {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int len = graph.length;
        boolean[] visited = new boolean[len];
        boolean[][] map = new boolean[len][len];

        visited[0] = true;
        for(int i = 0; i < len; i++){
            for(int t : graph[i]){
                map[i][t] = true;
            }
        }

        List<Integer> path = new ArrayList<>();
        path.add(0);
        search(visited, map, path);

        return res;
    }

    public void search(boolean[] visited, boolean[][] map, List<Integer> path){
        int source = path.get(path.size() - 1);
        if(source == visited.length - 1){
            List<Integer> temp = new ArrayList<>(path);
            res.add(temp);
            return;
        }

        boolean[] nextStops = map[source];

        for(int i = 0; i < nextStops.length; i++){
            if(!visited[i] && nextStops[i]){
                visited[i] = true;
                path.add(i);

                search(visited, map, path);

                visited[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
