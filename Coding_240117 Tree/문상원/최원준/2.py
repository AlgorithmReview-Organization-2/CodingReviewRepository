# https://www.acmicpc.net/problem/1068 트리

'''
1. 아이디어 :
    삭제하는 노드부터 내려간다. 해당 노드는 'del'
    해당 노드를 부모로하는 노드가 있으면 재귀함수 호출
2. 시간복잡도 :
    O( n )
3. 자료구조 :
    배열
'''
import sys

sys.setrecursionlimit(1000000)
input = sys.stdin.readline

n = int(input().rstrip())
nums = [int(num) for num in input().split()]
m = int(input().rstrip())


def dfs(node):
    nums[node] = 'del'
    for i in range(len(nums)):
        if node == nums[i]:
            dfs(i)


count = 0

dfs(m)
num_set = set(nums)
for i in range(len(nums)):
    if nums[i] != 'del' and i not in num_set:
        count += 1
print(count)
