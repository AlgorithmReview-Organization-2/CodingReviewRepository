# https://leetcode.com/problems/sum-root-to-leaf-numbers/description/

'''
1. 아이디어 :
    dfs
2. 시간복잡도 :
    O(leaves)
3. 자료구조 :
    -
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:

        def dfs(node, s):
            s+=str(node.val)

            if node.left:
                dfs(node.left, s)
            if node.right:
                dfs(node.right, s)

            if not node.left and not node.right:
                ans[0]+=(int(s))
                return

        ans = [0]
        dfs(root,"")
        return ans[0]
