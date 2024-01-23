# https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/

'''
1. 아이디어 :
    찾을 때까지 재귀하면 되는데, 클론이랑 오리지널 둘 다 필요한지 모르겠음
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
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(cloned == null) return null;
        
        if(target.val == cloned.val) return cloned;
        
        // 오리지널이랑 클론 굳이 2개가 필요한가?
        TreeNode left = getTargetCopy(original, cloned.left, target);
        if (left != null)  return left;
        
        return getTargetCopy(original, cloned.right, target);
    }
}
