package Tree;

public class _6057 {
    int res = 0;
    public int averageOfSubtree(TreeNode root) {
        visitAll(root);
        return res;
    }

    private int[] visitAll(TreeNode root){
        if (root == null)return new int[]{0, 0};

        int[] left = visitAll(root.left);
        int[] right = visitAll(root.right);

        int sum = left[0] + right[0] + root.val;
        int nums = left[1] + right[1] + 1;
        if (root.val == (sum / nums))res++;

        return new int[]{sum, nums};
    }
}
