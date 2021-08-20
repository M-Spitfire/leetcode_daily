package TwoPointers;

public class _345_ReverseVowelsOfaString {
    public static String reverseVowels(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] chs = s.toCharArray();

        do{
            left = findVowel(left, chs);
            right = lastFindVowel(right, chs);
            if(left == -1 || right == -1 || right <= left)break;
            char temp = chs[left];
            chs[left] = chs[right];
            chs[right] = temp;

            left++;
            right--;
        }
        while(left < right);

        return new String(chs);
    }

    public static int findVowel(int start, char[] chs){
        for(int i = start; i < chs.length; i++){
            if(isVowel(chs[i])){
                return i;
            }
        }

        return -1;
    }

    public static int lastFindVowel(int start, char[] chs){
        for(int i = start; i >= 0; i--){
            if(isVowel(chs[i])){
                return i;
            }
        }

        return -1;
    }

    public static boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }

    public static void main(String[] args) {
        String res = reverseVowels("hello");
        System.out.println(res);
    }
}
