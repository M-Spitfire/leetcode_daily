package Backtracking;

import java.util.TreeSet;

public class _942 {
    char[] chs;
    int[] res;
    TreeSet<Integer> treeSet = new TreeSet<>();
    public int[] diStringMatch(String s) {
        chs = s.toCharArray();
        int len = chs.length;
        res = new int[len + 1];
        res[0] = -1;
        for (int i = 0; i <= len; i++){
            treeSet.add(i);
        }

        for (int i = 0; i <= len; i++){
            res[0] = i;
            treeSet.remove(i);
            if (search(1))return res;
            treeSet.add(i);
        }
        return null;
    }

    private boolean search(int currentIndex){
        boolean isBigger =  chs[currentIndex - 1] == 'I';
        Integer selectedNum = isBigger ? treeSet.higher(res[currentIndex - 1]) : treeSet.lower(res[currentIndex - 1]);
        while (selectedNum != null){
            res[currentIndex] = selectedNum;
            //如果已经是最后一个数了，直接作为答案返回
            if (currentIndex == res.length - 1)return true;

            treeSet.remove(selectedNum);
            boolean flag = search(currentIndex + 1);
            if (flag)return true;
            treeSet.add(selectedNum);
            selectedNum = isBigger ? treeSet.higher(selectedNum) : treeSet.lower(selectedNum);
        }
        return false;
    }
}
