package String;

import java.util.ArrayList;
import java.util.List;

public class _5234 {
    public List<String> removeAnagrams(String[] words) {
        int len = words.length;
        List<String> res = new ArrayList<>();
        res.add(words[0]);
        for (int i = 0; i < len; ){
            int j = i + 1;
            for (; j < len; j++){
                if (words[j].length() != words[i].length()){
                    res.add(words[j]);
                    break;
                }
                // not meet conditions
                if (check(words[i], words[j])){
                    res.add(words[j]);
                    break;
                }
            }
            i = j;
        }
        return res;
    }

    private boolean check(String word, String word1) {
        int[] count1 = count(word);
        int[] count2 = count(word1);
        for (int i = 0; i < 26; i++){
            if (count1[i] != count2[i])return true;
        }
        return false;
    }

    private int[] count(String word) {
        int[] res = new int[26];
        for (int i = 0; i < word.length(); i++){
            res[word.charAt(i) - 'a']++;
        }
        return res;
    }
}
