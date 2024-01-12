# https://www.acmicpc.net/problem/1991

'''
1. 아이디어 :

2. 시간복잡도 :
    O(n)
3. 자료구조 :

'''


class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None


import sys

sys.setrecursionlimit(1000000)
input = sys.stdin.readline


def solution(root):
    ans = []

    def preorder(node):
        if not node:
            return ""

        left = preorder(node.left)
        right = preorder(node.right)
        s = node.val + left + right
        return s

    def inorder(node):
        if not node:
            return ""

        left = inorder(node.left)
        right = inorder(node.right)
        s = left + node.val + right
        return s

    def postorder(node):
        if not node:
            return ""

        left = postorder(node.left)
        right = postorder(node.right)
        s = left + right + node.val
        return s

    ans.append(preorder(root))
    ans.append(inorder(root))
    ans.append(postorder(root))
    return ans


hmap = {}
for _ in range(int(input().rstrip())):
    p, l, r = input().rstrip().split()
    if p in hmap:
        parent = hmap[p]
    else:
        parent = TreeNode(p)
        hmap[p] = parent
    if l != ".":
        left = TreeNode(l)
        hmap[l] = left
        parent.left = left
    if r != ".":
        right = TreeNode(r)
        hmap[r] = right
        parent.right = right

for a in (solution(hmap["A"])):
    print(a)
