package BFS;
import java.util.*;

/*
 * @lc app=leetcode.cn id=752 lang=java
 *
 * [752] 打开转盘锁
 * 广度优先搜索可解, 但是普通的广度优先搜索存在空间膨胀的问题(如果每一轮搜索的宽度较大, 那么使用的内存空间将会非常大)
 * 本题的宽度为8(一共四位数, 每一位数都可能加一或减一), 空间膨胀问题就已经需要考虑了
 * 因此我们使用双向广度优先搜索, 一边从起点搜索终点, 一边从终点搜索起点, 两边的第一次相遇就是步骤最少的变换
 * 如果两边没有相遇, 说明不存在能够从起点到终点的变换
 */

public class _752_OpenTheLock {
    Set<String> set = new HashSet<>();
    String s, t;
    public int openLock(String[] deadends, String target) {
        s = "0000";
        t = target;
        // 如果目标字符串就是"0000", 那么不用任何操作就到达了目标
        if(s.equals(target))return 0;
        set.addAll(Arrays.asList(deadends));
        // 如果起始字符串是"deadends"的成员, 那么不可能到达目标字符串
        if(set.contains(s))return -1;

        return bfs();
    }

    //双向广度优先搜索, 避免空间复杂度的指数上升
    public int bfs(){
        Deque<String> d1 = new ArrayDeque<>();
        Deque<String> d2 = new ArrayDeque<>();
        Map<String, Integer> m1 = new HashMap<>();
        Map<String, Integer> m2 = new HashMap<>();
        d1.add(s);
        d2.add(t);
        m1.put(s, 0);
        m2.put(t, 0);

        while(!d1.isEmpty() && !d2.isEmpty()){
            int t;
            if(d1.size() < d2.size()){
                t = update(d1, m1, m2);
            }
            else{
                t = update(d2, m2, m1);
            }
            if(t != -1)return t;
        }

        return -1;
    }

    public int update(Deque<String> queue, Map<String, Integer> cur, Map<String, Integer> others){
        String str1 = queue.removeFirst();
        int steps = cur.get(str1);
        char[] chs = str1.toCharArray();

        for(int i = 0; i < 4; i++){
            char ch = chs[i];
            for(int j = -1; j < 2; j++){
                if(j == 0)continue;

                int index = (ch - '0' + j) % 10;
                if(index == -1)index = 9;
                chs[i] = (char)(index + '0');
                String str2 = new String(chs);
                //得到新的字符串后将chs改回初始状态
                chs[i] = ch;

                if(set.contains(str2))continue; //如果当前结果咋在deadends中, 则当前结果无意义
                if(cur.containsKey(str2))continue;  //如果当前结果之前就已经得到过了, 则当前结果无意义, 越早得到步骤数越少
                //如果当前结果在方向相反的广度优先搜索中存在, 那么就是找到了一条"通路", 就是我们寻找的目标. 后面依然可能会有通路, 但步骤数量一定更大
                if(others.containsKey(str2)){
                    return 1 + steps + others.get(str2);
                }
                else{
                    //如果不是上面的三种情况, 那么将当前结果加入队列和哈希表中, 继续广度优先搜索
                    cur.put(str2, steps + 1);
                    queue.add(str2);
                }
            }
        }
        return -1;
    }
}

