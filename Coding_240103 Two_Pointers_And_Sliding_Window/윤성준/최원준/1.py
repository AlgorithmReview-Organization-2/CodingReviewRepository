# https://www.acmicpc.net/problem/1806

'''
1. 아이디어 :
    슬라이딩 윈도우. right를 하나씩 증가시키고, 안에 while문을 넣어서 left를 추가적으로 증가
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    배열
'''
import sys

sys.setrecursionlimit(1000000)
input = sys.stdin.readline


def solution(length, total, nums):
    ans = float('inf')
    left, right = 0, 1
    total -= nums[0]
    while right < len(nums):
        if total >= 0:
            total -= nums[right]
            right += 1
        else:
            total += nums[left]
            left += 1
        if total < 0:
            ans = min(ans, right-left)

    return ans if ans!=float('inf') else 0


n, m = list(map(int, input().split()))
integer_list = [int(num) for num in input().split()]

print(solution(n, m, integer_list))
