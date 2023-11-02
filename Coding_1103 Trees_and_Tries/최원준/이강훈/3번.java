/*
https://leetcode.com/problems/construct-quad-tree/description/

아이디어
최소 크기인 1 까지 분할 -> 정복하면서 Leaf 여부 확인 ( 아래 4개 분할이 모두 Leaf 이면서 , 4개의 값이 모두 동일한 것이 리프 )
 -> 리프면 아래 4개 null, 아니면 유지

자료구조
변수

시간복잡도
O(N^2) // 행 * 열
*/

public class Solution {
    int[][] grid;

    public Node construct(int[][] grid) {
        this.grid = grid;

        return divide(0, 0, grid.length);
    }

    public Node divide(int x, int y, int size) {
        if (size == 1) return new Node(grid[y][x] == 1, true);

        Node node = new Node();
        node.topLeft = divide(x, y, size / 2);
        node.topRight = divide(x + size / 2, y, size / 2);
        node.bottomLeft = divide(x, y + size / 2, size / 2);
        node.bottomRight = divide(x + size / 2, y + size / 2, size / 2);

        if (node.topLeft.isLeaf && node.topRight.isLeaf && node.bottomLeft.isLeaf && node.bottomRight.isLeaf) {
            if (node.topLeft.val == node.topRight.val && node.topLeft.val == node.bottomLeft.val && node.topLeft.val == node.bottomRight.val){
                return new Node(node.topLeft.val, true);
            }
        }

        node.val = true;
        return node;
    }
}

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