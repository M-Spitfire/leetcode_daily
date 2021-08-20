package Tree;
/**
 * leetcode_897
 * 
 * 简单的中序遍历, 只是空间可以再优化
 */
public class _897_IncreasingOrderSearchTree {
    TreeNode res = null;
    TreeNode pre = null;
    public TreeNode increasingBST(TreeNode root) {
        if(root == null)return null;

        TreeNode left = root.left;
        TreeNode right = root.right;

        //遍历左子树
        increasingBST(left);
        //处理根节点
        if(pre == null){
            res = root;
            pre = root;
            res.left = null;
            res.right = null;
        }
        else{
            pre.right = root;
            pre = root;
            pre.left = null;
            pre.right = null;
        }
        //遍历右子树
        increasingBST(right);

        return res;
    }
}
