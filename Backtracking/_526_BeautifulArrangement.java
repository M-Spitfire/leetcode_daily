package Backtracking;
/*
 * @lc app=leetcode.cn id=526 lang=java
 *
 * [526] 优美的排列
 */

/**
 * 这种题目必然是需要遍历所有排列, 然后校验并计数结果的题目用回溯必然可解, 看题解还有动态规划的方法
 */

public class _526_BeautifulArrangement {
    int res = 0;
    int limit;
    public int countArrangement(int n) {
        boolean[] used = new boolean[n + 1];
        int[] board = new int[n + 1];
        limit = n;

        search(1, used, board);

        return res;
    }

    public void search(int index, boolean[] used, int[] board){
        //如果数组已经被填满了, 表示找到一个符合条件的序列
        if(index > limit){
            res++;
            return;
        }

        for(int i = 1; i < used.length; i++){
            //该数字没有被使用过, 且符合题目给定的条件, 进行下一轮搜索
            if(!used[i] && (i % index == 0 || index % i == 0)){
                used[i] = true;
                board[index] = i;

                search(index + 1, used, board);

                //回溯后设置回原来的状态
                used[i] = false;
                board[index] = 0;
            }
        }
    }
}

