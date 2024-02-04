# https://www.acmicpc.net/problem/1927

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

nums = []
for _ in range(int(input().rstrip())):
    n = int(input().rstrip())
    if n == 0:
        if not nums:
            print(0)
        else:
            print(heapq.heappop(nums))
    else:
        heapq.heappush(nums, n)
