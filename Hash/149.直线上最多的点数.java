package Hash;
import java.util.HashMap;
import java.util.Map;



/*
 * @lc app=leetcode.cn id=149 lang=java
 *
 * [149] 直线上最多的点数
 */

// @lc code=start
class Solution {
    public static int maxPoints(int[][] points) {
        if(points.length < 3)return points.length;
        int res = 0;
        /**
         * 枚举所有点的组合, 自己写一个分数来表示两个点组成的直线的斜率
         */
        for(int i = 0; i < points.length; i++){
            Map<Integer, Integer> repo = new HashMap<>();
            // 只需要考虑后面的点即可, j<i时的情况在之前i的值中已经考虑过了
            for(int j = i + 1; j < points.length; j++){
                int a = points[j][0] - points[i][0];
                int b = points[j][1] - points[i][1];
                /**
                 * 1. 题目确保不会出现重复的点(a, b不全为0)
                 * 2. 斜率可能是负数, 进行适当处理以适合比较
                 */
                if(a == 0){
                    b = 1;
                }
                else if(b == 0){
                    a = 1;
                }
                else{
                    //保证a是正的
                    if(a < 0){
                        a = -a;
                        b = -b;
                    }
                    int g = gcd(a, b);
                    a = a / g;
                    b = b / g;
                }
                int key = a * 13768 + b;    //自己造一个key
                repo.put(key, repo.getOrDefault(key, 0) + 1);
            }
            for(int n : repo.values()){
                res = Math.max(res, 1 + n);
            }
        }
        return res;
    }

    public static int gcd(int a, int b){
        //保证a是更大的那一个
        if(a < b){
            int temp = a;
            a = b;
            b = temp;
        }
        while(b != 0){
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        int[][] points = {
            {1,1},
            {3,2},
            {5,3},
            {4,1},
            {2,3},
            {1,4}
        };
        int n = maxPoints(points);
        System.out.println(n);
    }
}
// @lc code=end
// {1,1},
// {2,2},
// {3,3}

// {1,1},
// {3,2},
// {5,3},
// {4,1},
// {2,3},
// {1,4}