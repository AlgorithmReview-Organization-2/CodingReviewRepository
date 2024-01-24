import sys
input = sys.stdin.readline#빠른 입력을 위한 함수
sys.setrecursionlimit(10 ** 7)#재귀 깊이를 늘려줌

n = int(input())#노드의 개수
inorder = list(map(int, input().split()))#중위 순회
postorder = list(map(int, input().split()))#후위 순회

nodeNum = [0] * (n + 1)#노드의 번호를 저장할 리스트
for i in range(n):#노드의 번호를 저장
    nodeNum[inorder[i]] = i#노드의 번호를 저장

def preorder(inStart, inEnd, postStart, postEnd):#전위 순회
    """
    전위 순회(preorder traversal)를 수행하는 함수입니다.

    Parameters:
        inStart (int): 중위 순회의 시작 인덱스
        inEnd (int): 중위 순회의 끝 인덱스
        postStart (int): 후위 순회의 시작 인덱스
        postEnd (int): 후위 순회의 끝 인덱스

    Returns:
        None
    """
    if (inStart > inEnd) or (postStart > postEnd):#인덱스가 범위를 벗어나면
        return
    
    root = postorder[postEnd]#후위 순회의 마지막 노드가 루트 노드
    
    leftNode = nodeNum[root] - inStart#왼쪽 서브트리의 노드 개수
    rightNode = inEnd - nodeNum[root]#오른쪽 서브트리의 노드 개수
    
    print(root, end = " ")
    preorder(inStart, inStart + leftNode - 1, postStart, postStart + leftNode - 1)#왼쪽 서브트리
    preorder(inEnd - rightNode + 1, inEnd, postEnd - rightNode, postEnd - 1)#오른쪽 서브트리의 노드 개수만큼 빼줌

preorder(0, n - 1, 0, n - 1)#전위 순회