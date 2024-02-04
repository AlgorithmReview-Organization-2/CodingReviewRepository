# https://www.acmicpc.net/problem/13975

'''
1. 아이디어 :
    heapq를 사용하는 간단한 문제
2. 시간복잡도 :
    O( nlogn )
3. 자료구조 :
    힙
'''
import heapq
import sys
sys.setrecursionlimit(1000000)
input = sys.stdin.readline


for _ in range(int(input().rstrip())):
    k = int(input().rstrip())
    nums = [int(num) for num in input().split()]
    heapq.heapify(nums)
    ans = 0

    while len(nums) >= 2:
        temp1 = heapq.heappop(nums)
        temp2 = heapq.heappop(nums)
        ans += temp1 + temp2
        heapq.heappush(nums, temp1 + temp2)

    print(ans)
