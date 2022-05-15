package String;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class _388 {
    List<String> record = new ArrayList<>();
    public int lengthLongestPath(String input) {
        String[] dirOrFile = input.split("\\n");
        int res = 0;
        int len = dirOrFile.length;
        int currentDepth = 0;
        int maxDepth = 0;
        for (String s : dirOrFile) {
            int depth = calDepth(s);
            if (depth == currentDepth) {
                if (currentDepth < maxDepth) {
                    record.set(currentDepth, s.substring(depth));
                } else record.add(s.substring(depth));
                currentDepth++;
                if (currentDepth > maxDepth) maxDepth = currentDepth;
            } else {
                record.set(depth, s.substring(depth));
                currentDepth = depth + 1;
            }
            if (isFile(s)) {
                res = Math.max(res, getPathLength(currentDepth));
            }
        }
        return res;
    }

    private int getPathLength(int currentDepth) {
        int res = 0;
        for (int i = 0; i < currentDepth; i++){
            res += record.get(i).length();
        }
        return res + currentDepth - 1;
    }

    private boolean isFile(String s) {
        return s.contains(".");
    }

    private int calDepth(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '\t'){
                count++;
            }
            else break;
        }
        return count;
    }

    @Test
    public void test(){
        String str = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        System.out.println(lengthLongestPath(str));
    }
}
