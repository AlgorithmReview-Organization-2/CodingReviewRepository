# https://www.acmicpc.net/problem/15900 나무 탈출

'''
1. 아이디어 :
    stack으로 풀 수 있다.
2. 시간복잡도 :
    O( n )
3. 자료구조 :
    스택
'''
import sys

sys.setrecursionlimit(1000000)
input = sys.stdin.readline

n = int(input().rstrip())
graph = [[] for _ in range(n + 1)]
for _ in range(n - 1):
    a, b = list(map(int, input().split()))
    graph[a].append(b)
    graph[b].append(a)

stack = [[1, 0]]
visited = [0] * (n+1)
visited[1] = 1

leaves = []
while stack:
    curr, depth = stack.pop()
    visited[curr] = 1

    if curr != 1 and len(graph[curr]) == 1:
        leaves.append(depth)
        continue

    for child in graph[curr]:
        if visited[child] == 0:
            stack.append([child, depth + 1])

total = sum(leaves)
print("Yes" if total % 2 == 1 else "No")
