# https://www.acmicpc.net/problem/7662

'''
1. 아이디어 :
    최소힙, 최대힙, 해시맵을 통해서 풀 수 있다.
    추가 될때, 해시맵에 카운트를 하나 추가한다.
    제외 될때, 제일 앞의 값의 카운트가 0이면 이미 제외된거기때문에, 제외시키고,
    하나를 제외시킨 후 카운트를 하나 뺀다.
    n번 반복하고,
    마지막으로도 제외를 시킨다음에, length에 따라 출력하면 된다.
2. 시간복잡도 :
    O(t*n*nlogn)
3. 자료구조 :
    힙, 해시맵
'''
import sys

input = sys.stdin.readline

import heapq
from collections import defaultdict

for _ in range(int(input())):
    n = int(input())
    min_heap = []
    max_heap = []
    exist = defaultdict(int)
    for _ in range(n):
        action, num = input().split()
        num = int(num)

        if action == "I":
            heapq.heappush(max_heap, -num)
            heapq.heappush(min_heap, num)
            exist[num] += 1
        elif action == "D":
            if num == 1:
                while max_heap and exist[-max_heap[0]] == 0:
                    heapq.heappop(max_heap)
                if max_heap:
                    del_num = -heapq.heappop(max_heap)
                    exist[del_num] -= 1
            elif num == -1:
                while min_heap and exist[min_heap[0]] == 0:
                    heapq.heappop(min_heap)
                if min_heap:
                    del_num = heapq.heappop(min_heap)
                    exist[del_num] -= 1

    while max_heap and exist[-max_heap[0]] == 0:
        heapq.heappop(max_heap)
    while min_heap and exist[min_heap[0]] == 0:
        heapq.heappop(min_heap)

    if len(min_heap) == 0:
        print("EMPTY")
    elif len(min_heap) == 1:
        print(min_heap[0], min_heap[0])
    else:
        print(-max_heap[0], min_heap[0])
