package BFS;

import org.junit.Test;

import javax.naming.ldap.StartTlsRequest;
import java.util.ArrayDeque;
import java.util.Deque;

public class _433 {
    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end))return 0;

        int len = bank.length;
        int[][] map = new int[len][len];

        //构建邻接矩阵
        for (int i = 0; i < len; i++){
            for (int j = i + 1; j < len; j++){
                if (diffString(bank[i], bank[j]) == 1){
                    map[i][j] = 1;
                    map[j][i] = 1;
                }
            }
        }

        int res = 0;
        //BFS
        Deque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[len];
        for (int i = 0; i < len; i++){
            int diff = diffString(start, bank[i]);
            if (diff == 0){
                queue.clear();
                queue.addLast(i);
                for (int j = 0; j < len; j++){
                    visited[j] = false;
                }
                visited[i] = true;
                res = -1;
                break;
            }
            else if (diff == 1){
                queue.addLast(i);
                visited[i] = true;
            }
        }

        while (!queue.isEmpty()){
            int n = queue.size();
            res++;
            for (int i = 0; i < n; i++){
                int pre = queue.pollFirst();
                if (end.equals(bank[pre]))return res;

                for (int j = 0; j < len; j++){
                    if (map[pre][j] == 1 && !visited[j]){
                        queue.addLast(j);
                        visited[j] = true;
                    }
                }
            }
        }

        return -1;
    }

    private int diffString(String str1, String str2){
        int count = 0;
        for(int i = 0; i < 8; i++){
            if(str1.charAt(i) != str2.charAt(i))count++;
        }
        return count;
    }

    @Test
    public void test(){
        String[] bank = {"AAAACCCC","AAACCCCC","AACCCCCC"};
        System.out.println(minMutation("AAAAACCC", "AACCCCCC", bank));
    }
}
