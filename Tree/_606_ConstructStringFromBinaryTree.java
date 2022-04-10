package Tree;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class _606_ConstructStringFromBinaryTree {
    /**
     * 本质上是先序遍历的题目
     */
    public String tree2str(TreeNode root) {
        StringBuffer res = new StringBuffer();
        build(root, res);
        return res.toString();
    }

    private void build(TreeNode root, StringBuffer res) {
        res.append(root.val);

        if(root.left != null){
            res.append('(');
            build(root.left, res);
            res.append(')');
        }

        if(root.right != null){
            if(root.left == null){
                res.append("()");
            }
            res.append('(');
            build(root.right, res);
            res.append(')');
        }
    }

    @Test
    public void test(){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;

        String res = tree2str(node1);

        System.out.println(res);
    }
}

