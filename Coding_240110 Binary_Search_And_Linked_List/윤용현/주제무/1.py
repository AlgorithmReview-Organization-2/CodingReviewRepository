'''
https://leetcode.com/problems/sum-root-to-leaf-numbers/description/

주제: 트리
시간복잡도: N

구현
child를 확인하고 있으면 dfs
'''


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        answer = []
        self.dfs(root, "", answer)

        return sum(map(int, answer))

    def dfs(self, node, cur_sum, result):
        if not node.left and not node.right:
            result.append(cur_sum + str(node.val))
            return

        if node.left:
            self.dfs(node.left, cur_sum + str(node.val), result)
        if node.right:
            self.dfs(node.right, cur_sum + str(node.val), result)