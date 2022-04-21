package String;

import java.util.Arrays;
import java.util.HashSet;

public class _824 {
    public String toGoatLatin(String sentence) {
        HashSet<Character> vowel = new HashSet<>(Arrays.asList('a','e','i','o','u'));
        String[] strs = sentence.split(" ");
        StringBuilder res = new StringBuilder();
        int len = strs.length;
        for(int i = 0; i < len; i++){
            if(vowel.contains(Character.toLowerCase(strs[i].charAt(0)))){
                res.append(strs[i]);
            }
            else{
                res.append(strs[i].substring(1));
                res.append(strs[i].charAt(0));
            }
            res.append("ma");
            for(int j = 0; j <= i; j++){
                res.append('a');
            }
            if(i != len - 1){
                res.append(' ');
            }
        }
        return res.toString();
    }
}
