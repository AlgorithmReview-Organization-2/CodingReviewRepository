# https://www.acmicpc.net/problem/10828

import sys
import heapq
heap = []
for j in range(int(sys.stdin.readline())):
    temp = int(sys.stdin.readline())
    if temp!=0:
        heapq.heappush(heap, -temp)
    else :
        if len(heap)!=0:
            print(-heapq.heappop(heap))
        else:
            print(0)

