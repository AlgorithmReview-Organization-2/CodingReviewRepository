"""
https://www.acmicpc.net/problem/1976

구현
- 플로이드 워셜 풀이
- 서로소 집합 풀이

서로소 풀이가 깔끔하고 좋네요
"""
N, M = map(int, [input() for _ in range(2)])

INF = int(1e9)
adj = []
for i in range(N):
    s = list(map(int, input().split()))
    for j in range(N):
        if i == j:
            s[j] = 1
            continue

        if s[j] == 0:
            s[j] = INF
    adj.append(s)

for k in range(N):
    for i in range(N):
        for j in range(N):
            adj[i][j] = min(adj[i][j], adj[i][k] + adj[k][j])

plan = [*map(lambda x: int(x)-1, input().split())]

result = True
pre_city = plan[0]
for cur_city in plan[1:]:
    if adj[pre_city][cur_city] >= INF:
        result = False
        break

    pre_city = cur_city

print("YES" if result else "NO")

""" disjoint-set 풀이
N, M = map(int, [input() for _ in range(2)])
parent = [i for i in range(N)]
adj = [list(map(int, input().split())) for _ in range(N)]


def find_parent(curr):
    p = parent[curr]
    if curr != p:
        parent[curr] = find_parent(p)
    return parent[curr]


def union(x, y):
    x, y = find_parent(x), find_parent(y)
    parent[x] = y
    return


for i in range(N):
    for j in range(i+1, N):
        if adj[i][j] == 1:
            union(i, j)

plan = [*map(lambda x: int(x)-1, input().split())]
result = True
pre_p = find_parent(plan[0])
for city in plan[1:]:
    if pre_p != find_parent(city):
        result = False
        break

print("YES" if result else "NO")
"""