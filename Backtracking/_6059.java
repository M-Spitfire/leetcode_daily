package Backtracking;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class _6059 {
    int n, m;
    char[][] grid;
    int[][] steps = {{-1,0},{0, -1},{1,0},{0,1}};
    public boolean hasValidPath(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        this.grid = grid;
        boolean[][] visited = new boolean[n][m];
        return search(0, 0, visited, new ArrayDeque<>());
    }

    private boolean search(int x, int y, boolean[][] visited, Deque<Character> queue) {
        if (grid[x][y] == ')'){
            if (queue.isEmpty())return false;
            else {
                queue.removeLast();
                if (x == n - 1 && y == m - 1 && queue.isEmpty())return true;
            }
        }
        else queue.addLast('(');
        visited[x][y] = true;

        for (int[] step : steps){
            int nextX = x + step[0];
            int nextY = y + step[1];
            if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && !visited[nextX][nextY]){
                boolean flag = search(nextX, nextY, visited, queue);
                if (flag)return true;
            }
        }

        visited[x][y] = false;
        return false;
    }

    @Test
    public void test(){
        char[][] grid = {{'(','(','('},{')','(',')'},{'(','(',')'},{'(','(',')'}};
        System.out.println(hasValidPath(grid));
    }
}
