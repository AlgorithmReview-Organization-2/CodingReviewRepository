# https://www.acmicpc.net/problem/2075

'''
1. 아이디어 :
    우선순위 큐 사용
2. 시간복잡도 :
    O(  )
3. 자료구조 :

'''
import heapq
import sys
sys.setrecursionlimit(1000000)
input = sys.stdin.readline

n = int(input().rstrip())
nums = []
for _ in range(n):
    for number in [int(num) for num in input().split()]:
        heapq.heappush(nums, number)
        if len(nums) > n:
            heapq.heappop(nums)
        print(nums)
print(nums[0])
