# https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

'''
1. 아이디어 :
    dfs를 통해 그래프를 만들고, 짝수 depth 마다 순서를 바꾼다
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    해시맵
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from collections import deque
class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:

        nums = {}

        def dfs(node, depth):
            if not node:
                return

            if depth not in nums:
                nums[depth] = []
            nums[depth].append(node.val)

            dfs(node.left, depth+1)
            dfs(node.right, depth+1)

        dfs(root, 0)
        ans = []

        for i in range(len(nums)):
            if i%2==0:
                ans.append(nums[i])
            else:
                ans.append(nums[i][::-1])

        return ans
