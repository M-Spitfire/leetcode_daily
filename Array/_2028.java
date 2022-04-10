package Array;

public class _2028 {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = mean * (rolls.length + n);

        for(int roll : rolls){
            sum -= roll;
        }

        if(sum < n || sum > 6 * n)return new int[0];

        int[] res = new int[n];
        int index = 0;
        for (int i = 0; i < n; i++){
            res[i] = 1;
        }
        sum -= n;
        while (sum > 0){
            if (sum > 5){
                res[index++] += 5;
                sum -= 5;
            }
            else {
                res [index++] += sum;
                sum -= sum;
            }
        }

        return res;
    }
}
