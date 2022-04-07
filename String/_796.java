package String;

public class _796 {
    char[] ch1;
    char[] ch2;
    int len;
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length())return false;
        ch1 = s.toCharArray();
        ch2 = goal.toCharArray();
        len = ch1.length;

        for (int i = 1; i <= ch1.length; i++){
            if (check(i))return true;
        }

        return false;
    }

    private boolean check(int mid){
        for (int i = 0; i < mid; i++){
            if (ch1[i] != ch2[len - mid + i])return false;
        }
        for (int i = mid; i < len; i++){
            if (ch1[i] != ch2[i - mid])return false;
        }
        return true;
    }
}
