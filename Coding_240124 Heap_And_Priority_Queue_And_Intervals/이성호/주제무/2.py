'''
https://www.acmicpc.net/problem/23843

주제
'''
import heapq

N, M = map(int, input().split())
times = sorted(list(map(int, input().split())), reverse=True)

tmp = []
for time in times:
    if len(tmp) < M:
        heapq.heappush(tmp, time)
    else:
        heapq.heappush(tmp, heapq.heappop(tmp) + time)
print(max(tmp))
