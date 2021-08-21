package Backtracking;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指38.字符串的排列
 * 
 * 回溯+set去重
 * 效率不高，以后再来优化
 */
public class _38_字符串的排列 {
    public String[] permutation(String s) {
        boolean[] visit = new boolean[s.length()];
        Set<String> set = new HashSet<>();
        build(s, visit, new StringBuilder(), set);
        String[] res = new String[set.size()];
        int i = 0;
        for(String str : set){
            res[i++] = str;
        }
        return res;
    }

    public void build(String s, boolean[] visit, StringBuilder sBuilder, Set<String> res){
        boolean flag = true;
        for(int i = 0; i < visit.length; i++){
            if(!visit[i]){
                visit[i] = true;
                sBuilder.append(s.charAt(i));
                build(s, visit, sBuilder, res);
                visit[i] = false;
                sBuilder.deleteCharAt(sBuilder.length() - 1);
                flag = false;
            }
        }
        if(flag){
            res.add(sBuilder.toString());
        }
    }
}