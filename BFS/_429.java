package BFS;

import Tree.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)return res;

        Deque<Node> deque = new ArrayDeque<>();

        deque.addLast(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++){
                Node t = deque.removeFirst();
                temp.add(t.val);
                for (Node node : t.children){
                    deque.addLast(node);
                }
            }
            res.add(temp);
        }

        return res;
    }
}
