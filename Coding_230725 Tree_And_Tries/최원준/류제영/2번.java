# https://leetcode.com/problems/maximum-depth-of-binary-tree/

'''
1. 아이디어 :
    dfs
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    트리
'''

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
    public int maxDepth(TreeNode root) {
        return dfs(root, 0);
    }
    
    int dfs(TreeNode node, int depth) {
        if(node == null) return depth;
        else return Math.max(dfs(node.left, depth+1), dfs(node.right, depth+1));
    }
}
