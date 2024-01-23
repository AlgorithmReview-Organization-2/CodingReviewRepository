# https://www.acmicpc.net/problem/1417

'''
1. 아이디어 :

2. 시간복잡도 :

3. 자료구조 :

'''

import heapq

n = int(input())
if n == 1:
    print(0)
    exit()
target, candidates = int(input()), [-int(input()) for _ in range(n - 1)]
count = 0

heapq.heapify(candidates)
while True:
    candid = -heapq.heappop(candidates)
    if target > candid:
        print(count)
        exit()
    else:
        heapq.heappush(candidates, -(candid - 1))
        count += 1
        target += 1
