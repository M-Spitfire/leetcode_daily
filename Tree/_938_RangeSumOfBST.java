package Tree;
/**
 * 
 * 简单的中序遍历题
 */
public class _938_RangeSumOfBST {

    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null)return 0;

        int res = rangeSumBST(root.left, low, high);
        if(root.val > high)return res;
        else if(root.val >= low) res += root.val;
        res += rangeSumBST(root.right, low, high);

        return res;
    }
}