package Array;

public class _1646_GetMaximumInGeneratedArray {
    public int getMaximumGenerated(int n) {
        if (n == 0)return 0;
        else if (n == 1)return 1;

        int[] data = new int[n + 1];
        data[1] = 1;

        int res = 1;
        boolean isOdd = false;
        for(int i = 2; i <= n; i++){
            if(isOdd){
                int base = i / 2;
                data[i] = data[base] + data[base + 1];
            }
            else{
                data[i] = data[i / 2];
            }
            res = Math.max(res, data[i]);
            isOdd = !isOdd;
        }
        return res;
    }
}
