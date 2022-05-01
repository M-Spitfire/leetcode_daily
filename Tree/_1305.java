package Tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1305 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        visitAll(root1, list1);
        visitAll(root2, list2);

        List<Integer> res = new ArrayList<>(list1.size() + list2.size());
        int point1 = 0;
        int point2 = 0;
        while (point1 < list1.size() && point2 < list2.size()){
            if (list1.get(point1) < list2.get(point2)){
                res.add(list1.get(point1++));
            }
            else res.add(list2.get(point2++));
        }
        while (point1 < list1.size()){
            res.add(list1.get(point1++));
        }
        while (point2 < list2.size()){
            res.add(list2.get(point2++));
        }
        return res;
    }

    private void visitAll(TreeNode root, List<Integer> list) {
        if (root == null)return;

        visitAll(root.left, list);
        list.add(root.val);
        visitAll(root.right, list);
    }

    @Test
    public void test(){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(4);
        node2.left = node1;
        node2.right = node3;
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(1);
        TreeNode node6 = new TreeNode(3);
        node5.left = node4;
        node5.right = node6;

        System.out.println(Arrays.toString(getAllElements(node2, node5).toArray()));

    }
}
