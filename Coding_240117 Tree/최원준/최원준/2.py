# https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/

'''
1. 아이디어 :
    인덱스를 저장하는 해시맵을 통해서 왼쪽 오른쪽 나눈다
2. 시간복잡도 :
    O( n )
3. 자료구조 :
    해시맵
'''

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        inorderidx = {v : i for i, v in enumerate(inorder)}
        print(inorderidx)

        def helper(l, r):
            if l > r:
                return None

            root = TreeNode(postorder.pop())

            idx = inorderidx[root.val]
            root.right = helper(idx + 1, r)
            root.left = helper(l, idx - 1)
            return root

        return helper(0, len(inorder) - 1)
