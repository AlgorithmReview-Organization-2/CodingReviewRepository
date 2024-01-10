# https://www.acmicpc.net/problem/2343 기타 레슨

'''
1. 아이디어 :

2. 시간복잡도 :

3. 자료구조 :

'''
import sys

sys.setrecursionlimit(1000000)
input = sys.stdin.readline


def solution(n, m, nums):
    if len(nums) == 1:
        return nums[0]

    def check(n):

        counts = 1
        temp = 0
        for time in nums:
            if temp + time > n:
                counts += 1
                temp = time
            else:
                temp += time
        return counts <= m

    left = min(nums)
    right = sum(nums)
    ans = sum(nums)
    while left <= right:
        mid = (left + right) // 2
        if check(mid):
            ans = min(ans, mid)
            right = mid - 1
        else:
            left = mid + 1
    return ans


n, m = list(map(int, input().split()))
integer_list = [int(num) for num in input().split()]
print(solution(n, m, integer_list))
