/*
https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/

아이디어
DFS 탐색 ( 같은 Depth 는 좌 -> 우 탐색 기록 ) -> 우 -> 좌로 탐색하는 depth 는 뒤집기

자료구조
ArrayList

시간복잡도
O(N)
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return answer;

        dfs(root, 0);

        for (int i = 0; i < answer.size(); i++) {
            if (i % 2 == 1) Collections.reverse(answer.get(i));
        }

        return answer;
    }

    public void dfs(TreeNode node, int depth) {
        if (answer.size() <= depth) answer.add(new ArrayList<>());

        answer.get(depth).add(node.val);

        if (node.left != null) dfs(node.left, depth + 1);
        if (node.right != null) dfs(node.right, depth + 1);
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
