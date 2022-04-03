package Greedy;

import org.junit.Test;

public class _6055 {
    public int convertTime(String current, String correct) {
        int diff = getMinute(correct) - getMinute(current);
        int res = 0;
        if (diff >= 60){
            int t = diff / 60;
            res += t;
            diff = diff - t * 60;
        }
        if (diff >= 15){
            int t = diff / 15;
            res += t;
            diff = diff - t * 15;
        }
        if (diff >= 5){
            int t = diff / 5;
            res += t;
            diff = diff - t * 5;
        }
        return res + diff;
    }

    private int getMinute(String time){
        String[] temp = time.split(":");
        return Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
    }

    @Test
    public  void test(){
        System.out.println(convertTime("02:30", "04:35"));
    }
}
