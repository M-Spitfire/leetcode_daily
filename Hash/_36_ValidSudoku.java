package Hash;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=36 lang=java
 *
 * [36] 有效的数独
 * 
 * 这题实际上没有什么太好的方法, 只能硬模拟: 逐行校验, 逐列校验, 逐个校验所有九宫格
 * 
 * 虽然思路简单, 但是实现还是有两种的:
 * 1. 只使用一个哈希表, 遍历三次board
 *      在空间上节省一些
 * 2. 使用三个哈希表, 只遍历一次board
 *      经典空间换时间
 */

public class _36_ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int[] count = new int[10];
        //检查行
        for(int i = 0; i < 9; i++){
            Arrays.fill(count, 0);
            for(char ch : board[i]){
                if(ch == '.')continue;
                int index = ch - '0';
                count[index]++;
                if(count[index] > 1)return false;
            }
        }
        //检查列
        for(int i = 0; i < 9; i++){
            Arrays.fill(count, 0);
            for(int j = 0; j < 9; j++){
                char ch = board[j][i];
                if(ch == '.')continue;
                int index = ch - '0';
                count[index]++;
                if(count[index] > 1)return false;
            }
        }
        //检查九宫格
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                Arrays.fill(count, 0);
                for(int p = i * 3; p < i * 3 + 3; p++){
                    for(int q = j * 3; q < j * 3 + 3; q++){
                        char ch = board[p][q];
                        if(ch == '.')continue;
                        int index = ch - '0';
                        count[index]++;
                        if(count[index] > 1)return false;
                    }
                }
            }
        }
        return true;
    }
}

