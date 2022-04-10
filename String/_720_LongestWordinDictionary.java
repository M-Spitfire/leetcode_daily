package String;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _720_LongestWordinDictionary {
    /**
     * 这里直接使用Set包含符合条件的所有字符串，方便查找
     */
    public String longestWord(String[] words) {
        Set<String> set = new HashSet<>();
        String res = "";
        set.add(res);

        Arrays.sort(words, (o1, o2) -> {
            if(o1.length() == o2.length()){
                return o1.compareTo(o2);
            }
            return o1.length() - o2.length();
        });

        int len = words.length;
        for (String word : words) {
            if (set.contains(word.substring(0, word.length() - 1))) {
                set.add(word);
                if (word.length() > res.length()) {
                    res = word;
                }
            }
        }

        return res;
    }

    /**
     * 由于不正确的排序方式，导致需要考虑更多的边界情况
     */
//    public String longestWord(String[] words) {
//        Arrays.sort(words);
//        System.out.println(Arrays.toString(words));
//        String res = "";
//        int len = words.length;
//        boolean[] recorder = new boolean[len];
//        for (int i = 0; i < len; ){
//            int l = words[i].length();
//            if (l == 1){
//                if(res.equals("")){
//                    res = words[i];
//                }
//                recorder[i] = true;
//
//                int j = i + 1;
//                for(; j < len; j++){
//                    if(words[j].length() == 1)break;
//                    boolean flag = false;
//                    for(int k = j - 1; k >= 0; k--){
//                        if(words[j].length() - 1 == words[k].length() && words[j].startsWith(words[k]) && recorder[k]){
//                            flag = true;
//                            recorder[j] = true;
//                            break;
//                        }
//                    }
//                    if (flag){
//                        if (words[j].length() > res.length()){
//                            res = words[j];
//                        }
//                    }
//                }
//                i = j;
//            }
//            else {
//                recorder[i] = false;
//                i += 1;
//            }
//        }
//        System.out.println(Arrays.toString(recorder));
//        return res;
//    }

    @Test
    public void test(){
        String[] words = {"rac","rs","ra","on","r","otif","o","onpdu","rsf","rs","ot","oti","racy","onpd"};
        System.out.println(longestWord(words));
        System.out.println("".length());
    }
}
