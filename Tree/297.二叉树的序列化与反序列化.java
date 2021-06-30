package Tree;
/*
 * @lc app=leetcode.cn id=297 lang=java
 *
 * [297] 二叉树的序列化与反序列化
 * 由于前序遍历能够方便的知道根节点的值, 因此这里我们使用了前序遍历进行序列化
 * 反序列化实际上也是进行了一次前序遍历, 在便利的过程中将所有节点创建好
 */

// @lc code=start
class Codec {

    String[] nodes = null;
    int index = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)return "/";
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.toString();
    }

    public void preOrder(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("[]/");
            return;
        }

        sb.append(root.val + "/");
        preOrder(root.left, sb);
        preOrder(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        nodes = data.split("/");
        if(nodes.length == 0)return null;
        TreeNode root = build();
        return root;
    }

    public TreeNode build(){
        
        if(index >= nodes.length || "[]".equals(nodes[index])){
            index++;
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.valueOf(nodes[index++]));
        root.left = build();
        root.right = build();
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end

