# https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/

'''
1. 아이디어 :
    dfs을 사용해서, 해당 target의 값을 찾는다.
2. 시간복잡도 :
    O(N)
3. 자료구조 :
    이진트리
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def getTargetCopy(self, original: TreeNode, cloned: TreeNode, target: TreeNode) -> TreeNode:

        def dfs(node):
            if not node:
                return

            if node.val == target.val:
                self.ans = node
                return node

            dfs(node.left)
            dfs(node.right)

        self.ans = None
        dfs(cloned)
        return self.ans
