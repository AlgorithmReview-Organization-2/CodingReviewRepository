# https://www.acmicpc.net/problem/15681

'''
1. 아이디어 :
    해시맵을 통해 연결하고, 미리 점들을 계산해놓는다.
2. 시간복잡도 :
    O( n )
3. 자료구조 :

'''
import sys
from collections import defaultdict

sys.setrecursionlimit(1000000)
input = sys.stdin.readline

graph = defaultdict(list)
scores = defaultdict(list)
visited = set()
N, R, Q = list(map(int, input().split()))
for _ in range(N - 1):
    U, V = list(map(int, input().split()))
    graph[U].append(V)
    graph[V].append(U)


def dfs(curr):
    visited.add(curr)

    points = 1
    for node in graph[curr]:
        if node not in visited:
            points += dfs(node)

    scores[curr] = points
    return points

dfs(R)

for _ in range(Q):
    print(scores[int(input())])
