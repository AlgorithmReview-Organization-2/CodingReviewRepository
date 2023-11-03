# https://leetcode.com/problems/check-completeness-of-a-binary-tree/description/

'''
1. 아이디어 :
    bfs로 풀 수 있다.
    배열에 값들을 넣고, 처음 null 값의 차례가 왔을떄, 그 뒤에 있는 값들은 null이 되면 안된다.
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    배열
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCompleteTree(self, root: Optional[TreeNode]) -> bool:

        q = deque([root])

        while q:
            node = q.popleft()

            if node:
                q.append(node.left)
                q.append(node.right)

            else:
                while q:
                    if q.popleft():
                        return False
        return True
