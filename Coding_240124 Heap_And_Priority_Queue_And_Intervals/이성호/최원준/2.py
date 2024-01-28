# https://www.acmicpc.net/problem/23843

'''
1. 아이디어 :

2. 시간복잡도 :
    O(  )
3. 자료구조 :

'''
import heapq
import sys

sys.setrecursionlimit(1000000)
input = sys.stdin.readline

n, m = list(map(int, input().split()))
devices = [int(num) for num in input().split()]
devices.sort()

if n <= m:
    print(max(n))
    exit()

time = 0
min_heap = []
while len(min_heap) < m:
    heapq.heappush(min_heap, devices.pop())

while devices:
    temp = heapq.heappop(min_heap)
    heapq.heappush(min_heap, devices.pop() + temp)
while min_heap:
    time = heapq.heappop(min_heap)

print(time)


'''
8 4 4 1 1

4 7
4 1 1

time = 7
8 8
1 1

time = 


'''
