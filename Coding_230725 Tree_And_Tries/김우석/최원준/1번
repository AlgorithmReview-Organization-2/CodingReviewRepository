# https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/

'''
1. 아이디어 :
    재귀적으로 배열에서 중앙을 기준으로 왼쪽 오른쪽을 만들면 된다.
2. 시간복잡도 :
    O(N)
3. 자료구조 :
    트리
'''


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sortedArrayToBST(self, nums: List[int]) -> Optional[TreeNode]:
        def balance(start, end):
            if start <= end:
                mid = (start + end) // 2
                node = TreeNode(nums[mid])

                node.left = balance(start, mid - 1)
                node.right = balance(mid + 1, end)
                return node

        return balance(0, len(nums) - 1)
