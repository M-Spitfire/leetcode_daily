package String;

public class _01_05_interview {
    public boolean oneEditAway(String first, String second) {
        int n = Math.max(first.length(), second.length());
        int m = Math.min(first.length(), second.length());
        if (n - m > 1)return false;
        if(n == 1)return true;
        char[] longer, shorter;
        if (n == first.length()){
            longer = first.toCharArray();
            shorter = second.toCharArray();
        }
        else{
            shorter = first.toCharArray();
            longer = second.toCharArray();
        }

        int res = 0;
        if( n == m){
            for (int i = 0; i < n; i++){
                if(longer[i] != shorter[i]){
                    res++;
                    if(res > 1)return false;
                }
            }
            return true;
        }
        else{
            int i = 0, j = 0;
            while(j < m && i < n){
                if (longer[i] != shorter[j]){
                    res++;
                    if(res > 1)return false;
                    j--;
                }
                i++;
                j++;
            }
            res += n + m - i - j;
            return res < 2;
        }
    }
}
