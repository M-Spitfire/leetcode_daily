package Tree;
/**
 * leetcode_938
 * 
 * 简单的中序遍历题
 */
class leetcode_938 {

    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null)return 0;

        int res = rangeSumBST(root.left, low, high);
        if(root.val > high)return res;
        else if(root.val >= low) res += root.val;
        res += rangeSumBST(root.right, low, high);

        return res;
    }

    public static void main(String[] args) {
        /**
         * 构建二叉树稍微有点麻烦, 这里就不演示了
         */
    }
}