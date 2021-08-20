package String;
/*
 * @lc app=leetcode.cn id=65 lang=java
 *
 * [65] 有效数字
 * 这个题目虽然标为困难，但是实际上直接硬模拟就行，在速度上不会比官方题解使用的状态机慢的
 */

public class _65_ValidNumber {
    public boolean isNumber(String s) {
        int index = s.indexOf('e');
        boolean isE;
        if(index == -1){
            index = s.indexOf('E');
            isE = index == s.lastIndexOf('E');
        }
        else{
            isE = index == s.lastIndexOf('e');
        }
        if(!isE)return false;
        else {
            if (index == -1)return isInteger(s) || isDecimal(s);
            else {
                String str1 = s.substring(0, index);
                String str2 = s.substring(index + 1);
                return (isInteger(str1) || isDecimal(str1)) && isInteger(str2);
            }
        }
    }

    public static boolean isInteger(String s){
        int len = s.length();
        if(len < 1)return false;
        char ch = s.charAt(0);
        if(!(ch == '+' || ch == '-' || (ch >= '0' && ch <= '9')))return false;
        for(int i = 1; i < len; i++){
            ch = s.charAt(i);
            if(ch >= '0' && ch <= '9')continue;
            else return false;
        }
        return true;
    }

    public static boolean isDecimal(String s){
        //确保只有一个小数点
        int index = s.indexOf('.');
        if(index == -1 || s.lastIndexOf('.') != index)return false;
        int len = s.length();
        boolean start = true;
        boolean left = false;
        boolean right = false;
        boolean isPoint = false;
        for(int i = 0; i < len; i++){
            char ch = s.charAt(i);
            if(ch >= '0' && ch <= '9'){
                if(isPoint)right = true;
                else left = true;
                continue;
            }
            else if(ch == '.'){
                isPoint = true;
            }
            else if(ch == '-' || ch == '+'){
                if(start){
                    start = false;
                }
                else return false;
            }
            else return false;
        }
        return left || right;
    }

    public static void main(String[] args) {
        String s = "0+.";
        System.out.println(isDecimal(s));
        System.out.println(isInteger(s));
    }
}

