package Tree;

import java.util.HashSet;
import java.util.Set;

public class _653_TwoSumIV_InputIsABST {
    int k = 0;
    Set<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        this.k = k;
        return search(root);
    }

    //先序遍历搜索，并制作备忘录（实际上也使用了备忘录）
    private boolean search(TreeNode root){
        if(root == null)return false;

        if(set.contains(k - root.val)){
            return true;
        }
        set.add(root.val);
        return search(root.left) || search(root.right);
    }
}
