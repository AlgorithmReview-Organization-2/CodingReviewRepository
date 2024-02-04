"""
https://www.acmicpc.net/problem/13023

"""
TARGET = 5
N, M = map(int, input().split())
g = [tuple(map(int, input().split())) for _ in range(M)]

friends = [[] for _ in range(N)]
for a, b in g:
    friends[a].append(b)
    friends[b].append(a)


def backtracking(cur, depth):
    if depth == TARGET:
        answer[0] = True
        return

    visited[cur] = True
    for adj in friends[cur]:
        if not visited[adj]:
            backtracking(adj, depth+1)
    visited[cur] = False


answer = [False]
visited = [False] * N
for cur in range(N):
    backtracking(cur, 1)
    if answer[0]:
        break

print(1 if answer[0] else 0)
