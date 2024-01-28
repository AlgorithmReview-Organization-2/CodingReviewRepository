'''
https://www.acmicpc.net/problem/1967

주제: 트리, dfs
'''
import sys
sys.setrecursionlimit(10_001)
input = lambda: sys.stdin.readline().rstrip()


def dfs(cur, acc):
    for adj, d in graph[cur]:
        if distance[adj] == -1:
            distance[adj] = acc + d
            dfs(adj, acc+d)


n = int(input())
graph = [[] for _ in range(n + 1)]
for _ in range(n - 1):
    n_1, n_2, d = map(int, input().split())
    graph[n_1].append([n_2, d])
    graph[n_2].append([n_1, d])

distance = [-1] * (n + 1)
distance[1] = 0
dfs(1, 0)

start = distance.index(max(distance))
distance = [-1] * (n + 1)
distance[start] = 0
dfs(start, 0)

print(max(distance))
