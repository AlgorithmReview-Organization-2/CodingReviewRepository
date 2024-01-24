# https://www.acmicpc.net/problem/2805 나무 자르기

'''
1. 아이디어 :

2. 시간복잡도 :

3. 자료구조 :

'''
import sys

sys.setrecursionlimit(1000000)
input = sys.stdin.readline


def solution(n, m, nums):
    left = 0
    right = max(nums)
    ans = 0
    while left <= right:
        height = (left + right) // 2
        total = sum([x - height for x in nums if x > height])
        if total >= m:
            left = height + 1
            ans = max(ans, height)
        else:
            right = height - 1

    return ans


n, m = list(map(int, input().split()))
integer_list = [int(num) for num in input().split()]

print(solution(n, m, integer_list))
