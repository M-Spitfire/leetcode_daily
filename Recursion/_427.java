package Recursion;

/*
题目保证了给定的二维数组是n x n的，且n为2的整数幂
 */
public class _427 {

    private int[][] grid;
    public Node construct(int[][] grid) {
        this.grid = grid;
        return build(0, 0, grid.length);
    }

    private Node build(int x, int y, int len){
        if (len == 1)return new Node(grid[x][y] == 1, true);

        int l = len / 2;
        Node topLeft = build(x, y, l);
        Node topRight = build(x, y + l, l);
        Node bottomLeft = build(x + l, y, l);
        Node bottomRight = build(x + l, y + l, l);

        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf){
            if (topLeft.val == topRight.val && topLeft.val == bottomLeft.val && topLeft.val == bottomRight.val){
                return new Node(topLeft.val, true);
            }
        }
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}


// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}

