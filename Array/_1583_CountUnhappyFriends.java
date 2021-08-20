package Array;
/*
 * @lc app=leetcode.cn id=1583 lang=java
 *
 * [1583] 统计不开心的朋友
 */

/**
 * 模拟题
 * 由于题目给的数据就够不适合进行题目要求的搜索过程，所以需要转换一下
 */

public class _1583_CountUnhappyFriends {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[][] friendOrders = new int[n][n];
        int[] map = new int[n];
        int res = 0;

        //将题目给的preferences转换成类似邻接矩阵的结构, 其中值代表两个人的关系亲密程度， 值越小亲密程度越高啊
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n - 1; j++){
                int friend = preferences[i][j];
                friendOrders[i][friend] = j;
            }
        }

        //将所有配对信息放在同一个数组中，方便查找
        for(int i = 0; i < n / 2; i++){
            int p1 = pairs[i][0], p2 = pairs[i][1];
            map[p1] = p2;
            map[p2] = p1;
        }

        //逐个查找符合条件的人，相当于暴力搜索了
        for(int i = 0; i < n; i++){
            int limit = friendOrders[i][map[i]];
            for(int j = 0; j < limit; j++){
                int person = preferences[i][j];
                int personFriend = map[person];
                if(friendOrders[person][i] < friendOrders[person][personFriend]){
                    res++;
                    break;
                }
            }
        }

        return res;
    }
}

