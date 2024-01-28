# https://www.acmicpc.net/problem/11725

'''
1. 아이디어 :
    부모랑 연결된 노드들을 queue를 통해 구한다
2. 시간복잡도 :
    O( n )
3. 자료구조 :
    해시맵
'''
import sys
from collections import defaultdict, deque

sys.setrecursionlimit(1000000)
input = sys.stdin.readline

n = int(input().rstrip())


def solution(n):
    graph = defaultdict(list)
    dist = defaultdict(int)
    for _ in range(n-1):
        s, e = list(map(int, input().split()))
        graph[s].append(e)
        graph[e].append(s)

    queue = deque()
    queue.append(1)

    while queue:
        curr = queue.popleft()
        for node in graph[curr]:
            if node not in dist:
                dist[node] = curr
                queue.append(node)

    for node in range(2, n+1):
        print(dist[node])


solution(n)
