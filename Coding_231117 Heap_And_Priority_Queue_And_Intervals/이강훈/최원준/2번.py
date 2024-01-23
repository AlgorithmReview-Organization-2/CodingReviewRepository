# https://www.acmicpc.net/problem/1715

'''
1. 아이디어 :
    힙 사용
    제일 작은걸 두개 더하고, 다시 힙에 넣는다.
2. 시간복잡도 :
    O(nlogn)
3. 자료구조 :
    힙
'''

import heapq
import sys

input = sys.stdin.readline

n = int(input())
cards = []
for i in range(n):
    heapq.heappush(cards, int(input()))

cmax = 0
while len(cards) >= 2:
   smaller = heapq.heappop(cards)
   small = heapq.heappop(cards)
   heapq.heappush(cards, smaller+small)
   cmax += smaller + small

print(cmax)
