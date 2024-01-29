# https://www.acmicpc.net/problem/ 트리의 기둥과 가지

'''
1. 아이디어 :
    bfs로 풀었다.
    가지까지 가는거와 리프까지 가는거 두개 나눠서 연산
2. 시간복잡도 :
    O( n )
3. 자료구조 :

'''
import sys
from collections import defaultdict, deque

sys.setrecursionlimit(1000000)
input = sys.stdin.readline

n, m = list(map(int, input().split()))
dist = defaultdict(list)
graph = defaultdict(list)

for _ in range(n - 1):
    s, e, d = list(map(int, input().split()))
    graph[s].append(e)
    graph[e].append(s)
    dist[(s, e)] = d
    dist[(e, s)] = d

queue = deque()
queue.append((m, 0))
visited = set()
while len(queue) == 1:
    curr, dis = queue.popleft()
    visited.add(curr)
    nodes = graph[curr]
    for node in nodes:
        if node not in visited:
            queue.append((node, dis + dist[(curr, node)]))

md = dis
if not queue:
    print(md, 0)
    exit()
ed = 0
while queue:
    curr, dis = queue.popleft()
    visited.add(curr)
    ed = max(ed, dis)
    nodes = graph[curr]
    for node in nodes:
        if node not in visited:
            queue.append((node, dis + dist[(curr, node)]))

print(md, ed - md)
