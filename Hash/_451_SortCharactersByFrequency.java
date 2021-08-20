package Hash;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=451 lang=java
 *
 * [451] 根据字符出现频率排序
 * 
 * 这个解法慢的一批, 建议不要参考
 * 
 * 推荐解法:
 *      ①将下面的方法中的两个map用int[128][2]代替, 
 *          128是因为题目可能出现大小写字母, 我们直接给所有ascii字符开一个哈希表, 这样可以直接使用char作为数组的下标
 *          2是为了存放两个数据, char对应的ascii值, 以及它的出现次数
 *        然后自定义排序算法进行排序, 最后进行字符串的拼接
 *      ②使用桶排序的思想, 但是这个了解不多, 在这里就不多说了
 */

public class _451_SortCharactersByFrequency {
    public String frequencySort(String s) {
        Map<Integer, Set<Character>> counter = new HashMap<>();
        Map<Character, Integer> map = new HashMap<>();
        char[] chs = s.toCharArray();
        for(char ch : chs){
            int index = map.getOrDefault(ch, 0);
            Set<Character> set1 = counter.getOrDefault(index, new HashSet<>());
            Set<Character> set2 = counter.getOrDefault(index + 1, new HashSet<>());
            set1.remove(ch);
            set2.add(ch);
            counter.put(index, set1);
            counter.put(index + 1, set2);
            map.put(ch, 1 + index);
        }

        StringBuilder sb = new StringBuilder();
        for(Set<Character> set : counter.values()){
            for(Character ch : set){
                int n = map.get(ch);
                for(int i = 0; i < n; i++){
                    sb.insert(0, ch);
                }
            }
        }
        return sb.toString();
    }
}

