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
// https://leetcode.com/problems/binary-tree-inorder-traversal/
//이진 트리의 루트가 주어지면 해당 노드 값의 중위 순회를 반환합니다.
// 시간복잡도 : O(N)
// 아이디어
// 1. 중위순회(Left -> Root -> Right) 메서드 따로 구현
// 2. root 기준 왼쪽 부터 방문해서 list로 만들고, root를 추가한 후, 오른쪽을 순회한다.
// 자료구조 : Tree, ArrayList
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        return ans;
    }

    public void inorder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right,list);
    }
}