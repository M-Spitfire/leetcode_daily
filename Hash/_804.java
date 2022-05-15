package Hash;

import java.util.HashSet;
import java.util.Set;

public class _804 {
    private static String[] arr = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        for (String str : words){
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < str.length(); i++){
                sb.append(arr[str.charAt(i) - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }

//    @Test
//    public void test(){
//
//    }
}
