package BFS;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;


/*
 * @lc app=leetcode.cn id=773 lang=java
 *
 * [773] 滑动谜题
 * 广度优先搜索
 * 每一轮的搜索宽度为4(上下左右, 但是由于只有两行三列, 因此实际上是3)
 * 可以考虑使用双向广度优先搜索, 这题的数据量比较小, 这里就不用了
 */

public class _773_SlidingPuzzle {
    public int slidingPuzzle(int[][] board) {
        Deque<String> queue = new ArrayDeque<>();
        Deque<Integer> indexQueue = new ArrayDeque<>();
        Set<String> pre = new HashSet<>();
        int steps = 0;
        int index = 0;  // denote 0's position
        String target = "123450";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 3; j++){
                sb.append(board[i][j]);
                if(board[i][j] == 0){
                    index = i * 3 + j;
                }
            }
        }
        int[][] changeMap = {
                {1,3,-1},
                {0,2,4},
                {1,5,-1},
                {0,4,-1},
                {1,3,5},
                {2,4,-1}
        };
        String start = sb.toString();
        if(target.equals(start))return 0;
        queue.add(sb.toString());
        indexQueue.add(index);
        while(!queue.isEmpty()){
            steps++;
            int n = queue.size();
            for(int i = 0; i < n; i++){
                char[] origin = queue.removeFirst().toCharArray();
                //1. 找到0的位置
                int zeroPos = indexQueue.remove();
                //2. 广度搜索
                for(int k = 0; k < 3; k++){
                    int changeTarget = changeMap[zeroPos][k];
                    if(changeTarget != -1){
                        char temp = origin[changeTarget];
                        origin[changeTarget] = '0';
                        origin[zeroPos] = temp;
                        String now = new String(origin);
                        //得到新的字符串后将origin改回原样
                        origin[changeTarget] = temp;
                        origin[zeroPos] = '0';

                        if(target.equals(now))return steps;
                        if(pre.contains(now))continue;
                        pre.add(now);
                        queue.add(now);
                        indexQueue.add(changeTarget);
                    }
                }

            }
        }

        return -1;
    }
}