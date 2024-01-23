# https://leetcode.com/problems/binary-tree-inorder-traversal/

'''
1. 아이디어 :
    이진 탐색처럼 품
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return makeTree(nums, 0, nums.length - 1);
    }
    
    TreeNode makeTree(int[] arr, int start, int end) {
        if(start > end) return null;
        
        int mid = (start + end) / 2;
        
        TreeNode root = new TreeNode(arr[mid]);
        
        root.left = makeTree(arr, start, mid - 1);
        root.right = makeTree(arr, mid + 1, end);
        
        return root;
    }
}
