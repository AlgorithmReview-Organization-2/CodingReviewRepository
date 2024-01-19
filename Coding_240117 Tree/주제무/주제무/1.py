'''
https://www.acmicpc.net/problem/11725


'''
import sys
input = lambda: sys.stdin.readline().rstrip()
sys.setrecursionlimit(100_001)


def dfs(parent, cur_node):
    for child in adj[cur_node]:
        if child == parent:
            continue

        parents[child] = cur_node
        dfs(cur_node, child)


N = int(input())
adj = {}
for _ in range(N-1):
    a, b = map(int, input().split())
    if a not in adj:
        adj[a] = []
    adj[a].append(b)

    if b not in adj:
        adj[b] = []
    adj[b].append(a)

parents = [None] * (N+1)
dfs(None, 1)
print(*parents[2:], sep="\n")
