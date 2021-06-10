package BinarySearch;
/**
 * leetcode_1011
 * 
 * 二分查找
 */
class leetcode_1011 {

    public static int shipWithinDays(int[] weights, int D) {
        int left = 0;
        //找到最小值
        for(int n : weights){
            if(n > left){
                left = n;
            }
        }
        int right = left * weights.length;

        while(left < right){
            /** 
             * int mid = (left + right) / 2;
             * 这种写法在这题里面不会出现问题, 但是仍然不可忽视其超过int表示范围的可能性
             * */ 
            int mid = left + (right - left) / 2;
            int pos = 0;
            int count = 0;
            int cur = 0;
            while(pos < weights.length){

                cur += weights[pos++];
                if(cur > mid){
                    count++;
                    cur = 0;
                    pos--;
                }
            }
            if(cur > 0){
                count++;
            }
            if(count > D){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        System.out.println("hello");
        int weights[] = {1,2,3,4,5,6,7,8,9,10};
        int res = shipWithinDays(weights, 5);
        System.out.println(res);
    }
}
