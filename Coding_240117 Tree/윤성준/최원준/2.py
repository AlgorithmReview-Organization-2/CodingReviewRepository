# https://www.acmicpc.net/problem/20955 민서의 응급 수술

'''
1. 아이디어 :

2. 시간복잡도 :
    O(  )
3. 자료구조 :

'''
import sys
from collections import defaultdict

sys.setrecursionlimit(1000000)
input = sys.stdin.readline


def union(n1, n2):
    p1, p2 = find(n1), find(n2)

    if p1 == p2:
        return False

    if rank[p1] > rank[p2]:
        par[p2] = p1
        rank[p1] += rank[p2]
    else:
        par[p1] = p2
        rank[p2] += rank[p1]
    return True


def find(x):
    if par[x] != x:
        par[x] = find(par[x])
    return par[x]


n, m = list(map(int, input().split()))

par = [i for i in range(n + 1)]
counts = 0
rank = [1] * (n + 1)

for _ in range(m):
    s, e = list(map(int, input().split()))
    if not union(s, e):
        counts += 1

for i in range(1, n + 1):
    if find(i - 1) != find(i):
        union(i - 1, i)
        counts += 1

print(counts - 1)
