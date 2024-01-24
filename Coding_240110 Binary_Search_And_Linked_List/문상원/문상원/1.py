import sys

N = int(sys.stdin.readline().strip())#입력을 받아온다
tree = {}

for n in range(N):#입력한 노드의 수만큼 반복
    root, left, right = sys.stdin.readline().strip().split()# 사용자로부터 한 줄의 입력을 받습니다.
    tree[root] = [left, right]


def preorder(root):
    if root != '.':
        print(root, end='')  # root
        preorder(tree[root][0])  # left
        preorder(tree[root][1])  # right


def inorder(root):
    if root != '.':
        inorder(tree[root][0])  # left
        print(root, end='')  # root
        inorder(tree[root][1])  # right


def postorder(root):
    if root != '.':
        postorder(tree[root][0])  # left
        postorder(tree[root][1])  # right
        print(root, end='')  # root


preorder('A')
print()
inorder('A')
print()
postorder('A')