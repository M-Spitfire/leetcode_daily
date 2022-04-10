package BinarySearch;

public class _744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        int res = -1;

        while (left < right){
            int mid = left + (right - left) / 2;    //向下取整防溢出
            //符合大于target的要求
            if (letters[mid] > target){
                right = mid;
            }
            else left = mid + 1;
        }

        if (letters[left] > target)return letters[left];
        return letters[0];
    }
}
