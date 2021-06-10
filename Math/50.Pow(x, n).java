package Math;
/**
 * leetcode_50
 * 快速幂
 */
class leetcode_50 {

    public static double myPow(double x, int n) {
        //递归出口
        if(n == 0)return 1;
        else if(n == 1)return x;

        //递归主体
        double temp = myPow(x, n / 2);
        if(n % 2 == 0){
            return temp * temp;
        }
        else{
            return n > 0 ? (temp * temp * x) : (temp * temp / x);
        }
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.0, -3));
    }
    
}