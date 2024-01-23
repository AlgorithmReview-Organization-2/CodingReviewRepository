# https://leetcode.com/problems/find-duplicate-subtrees/description/

'''
1. 아이디어 :
    문자열을 만들어서 dfs를 돌리면 된다.
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    해시맵, 배열
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findDuplicateSubtrees(self, root: Optional[TreeNode]) -> List[Optional[TreeNode]]:

        subtrees = defaultdict(list)

        def dfs(node):
            if not node:
                return "null"
            s = ",".join([str(node.val), dfs(node.left), dfs(node.right)])
            if len(subtrees[s]) == 1:
                res.append(node)
            subtrees[s].append(node)
            return s

        res=[]
        dfs(root)
        return res
