# https://www.acmicpc.net/problem/2470 두 용액

'''
1. 아이디어 :

2. 시간복잡도 :

3. 자료구조 :

'''
import sys

sys.setrecursionlimit(1000000)
input = sys.stdin.readline


def solution(n, nums):
    nums.sort()
    ans = [0, 0]
    l, r = 0, n - 1
    diff = float('inf')

    while l <= r:
        total = abs(nums[l] + nums[r])
        if total < diff:
            diff = total
            ans = [nums[l], nums[r]]

        if nums[l] + nums[r] > 0:
            r -= 1
        else:
            l += 1

    return ans


n = int(input().rstrip())
integer_list = [int(num) for num in input().split()]
print(*solution(n, integer_list))
