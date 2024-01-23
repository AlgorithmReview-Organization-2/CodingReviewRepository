# https://www.acmicpc.net/problem/1374

'''
1. 아이디어 :
    두개의 힙을 만든다.
    heap1에는 강의의 시작시간, 끝나는 시간, 강의 번호를 저장한다.
    heap2에는 강의의 끝나는 시간을 저장한다.
    heap1을 시작시간 순으로 정렬하고, heap2를 끝나는 시간 순으로 정렬한다.
    heap1에서 강의를 하나씩 꺼내면서 heap2의 가장 빨리 끝나는 강의가 끝나는 시간보다 시작시간이 빠르면 heap2에서 꺼낸다.
2. 시간복잡도 :
    O(NlogN)
3. 자료구조 :
    힙
'''

import heapq

n = int(input())
heap1, heap2 = [], []
count = 0
for _ in range(n):
    num, start, end = map(int, input().split())
    heapq.heappush(heap1, [start, end, num])

start, end, num = heapq.heappop(heap1)
heapq.heappush(heap2, end)
while heap1:
    start, end, num = heapq.heappop(heap1)
    if heap2[0] <= start:
        heapq.heappop(heap2)
    heapq.heappush(heap2, end)

print(len(heap2))
