package String;
/*
 * @lc app=leetcode.cn id=551 lang=java
 *
 * [551] 学生出勤记录 I
 */

public class _551_StudentAttendanceRecord_I {
    public boolean checkRecord(String s) {
        return s.indexOf("A") == s.lastIndexOf("A") && s.indexOf("LLL") == -1;
    }
}

