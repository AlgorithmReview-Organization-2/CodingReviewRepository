// https://leetcode.com/problems/invert-binary-tree/
// 이진 트리의 루트가 주어지면 트리를 반전하고 루트를 반환
// 시간복잡도 : O(n)
// 아이디어 : 자식노드 왼쪽,오른쪽 바꾸기
// 자료구조 : tree

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
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}