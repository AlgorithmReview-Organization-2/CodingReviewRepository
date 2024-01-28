# https://www.acmicpc.net/problem/13904 과제

'''
1. 아이디어 :
    마지막 날부터 처리할 수 있는 과제들을 우선순위 큐에 넣는다.
2. 시간복잡도 :
    O( nlogn )
3. 자료구조 :
    힙
'''
import heapq
import sys

sys.setrecursionlimit(1000000)
input = sys.stdin.readline

n = int(input().rstrip())
hw = []
for _ in range(n):
    a, b = list(map(int, input().split()))
    heapq.heappush(hw, (-a, b))
among = []

day = 0
ans = 0
for date in range(n, 0, -1):
    while hw and -hw[0][0] >= date:
        heapq.heappush(among, -heapq.heappop(hw)[1])
    if among:
        ans += -heapq.heappop(among)
print(ans)
