package BFS;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=909 lang=java
 *
 * [909] 蛇梯棋
 * 我这里将二维数组转换成一维数组, 这样在数组里的"传送"(不管是梯子还是蛇都是传送)就会方便很多
 */

// @lc code=start
class Solution {
    public static int snakesAndLadders(int[][] board) {
        int n = board[0].length;
        int target = n * n;
        int[] map = new int[target];
        boolean flag = true;
        int index = 0;
        for(int i = n - 1; i >= 0; i--){
            if(flag){
                for(int j = 0; j < n; j++){
                    map[index++] = board[i][j];
                }
            }
            else{
                for(int j = n - 1; j >= 0; j--){
                    map[index++] = board[i][j];
                }
            }
            flag = !flag;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        set.add(0);
        int step = 0;
        queue.add(0);

        while(!queue.isEmpty()){
            int len = queue.size();
            step++;
            System.out.print(step + ": ");
            for(int i = 0; i < len; i++){
                int origin = queue.remove();
                for(int j = 1; j < 7; j++){
                    int now = origin + j;
                    if(now >= target)continue;
                    if(map[now] != -1){
                        now = map[now] - 1;
                    }
                    if(set.contains(now))continue;
                    if(now == (target - 1))return step;
                    else{
                        queue.add(now);
                        set.add(now);
                        System.out.print(now + " ");
                    }
                }
            }
            System.out.println();
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] board = {
            {-1,-1,-1},
            {-1,9,8},
            {-1,8,9}
        };
        
        int res = snakesAndLadders(board);
        System.out.println(res);
    }
}
// @lc code=end

