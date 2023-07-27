/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// https://leetcode.com/problems/maximum-depth-of-binary-tree/
// 이진 트리의 루트가 주어지면 최대 깊이를 반환합니다.
// 이진 트리의 최대 깊이는 루트 노드에서 가장 먼 리프 노드까지 가장 긴 경로를 따라 있는 노드의 수입니다.
// 시간복잡도 : O(N)
// 아이디어 : root가 null인 경우 0, left subtree, right subtree 깊이 구한 후 비교해서 node 수이므로 +1
// 자료구조 : Tree
class Solution {
     public int maxDepth(TreeNode root) {
         if (root == null) return 0;
         int left = maxDepth(root.left);
         int right = maxDepth(root.right);
         return Math.max(left, right) + 1;
    }
}