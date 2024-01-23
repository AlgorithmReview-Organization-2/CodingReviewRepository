# https://www.acmicpc.net/problem/1927

'''
1. 아이디어 :
    1) Heapq 를 사용하면된다
2. 시간복잡도 :

3. 자료구조 :

'''


from heapq import *
import sys
heap = []
for _ in range(int(sys.stdin.readline())):
    command = int(sys.stdin.readline())
    print(0 if len(heap) == 0 else heappop(heap)) if command == 0 else heappush(heap,command)
