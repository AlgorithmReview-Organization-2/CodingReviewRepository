/*
https://leetcode.com/problems/check-completeness-of-a-binary-tree/

아이디어
완벽 이진 트리는 좌 -> 우 로 채움 ( 즉, 우가 채워졌는데 좌가 비어있으면 실패 )
 -> 큐로 BFS 탐색 ( 각 레벨 좌 -> 우 ) 하며 채우지만 Null 또한 채움, Null 이 나왔는데 그 후에 값이 있는 것이 나오면 False 인 것

자료구조
큐

시간복잡도
O(N)
*/

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public boolean isCompleteTree(TreeNode root) {
        boolean isFindLast = false;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();

            if (node == null){
                isFindLast = true;
                continue;
            } else {
                if (isFindLast) return false;
            }

            queue.add(node.left);
            queue.add(node.right);
        }

        return true;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
