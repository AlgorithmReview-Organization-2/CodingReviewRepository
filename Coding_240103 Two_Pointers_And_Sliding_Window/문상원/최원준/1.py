# https://www.acmicpc.net/problem/2018 수들의 합 5

'''
1. 아이디어 :
    슬라이딩 윈도우로 풀 수 있다
2. 시간복잡도 :
    o(n)
3. 자료구조 :
    -
'''
import sys

sys.setrecursionlimit(1000000)
input = sys.stdin.readline


def solution(n):
    left = right = total = count = 0
    while right <= n + 1:
        if total == n:
            count += 1
            total += right - left
            right += 1
            left += 1
        elif total < n:
            total += right
            right += 1
        elif total > n:
            total -= left
            left += 1
    return count


n = int(input().rstrip())
print(solution(n))
