# https://www.acmicpc.net/problem/2428 표절

'''
1. 아이디어 :
    이분탐색
2. 시간복잡도 :
    O(nlogn)
3. 자료구조 :
    배열
'''
import sys

sys.setrecursionlimit(1000000)
input = sys.stdin.readline


def solution(sizes):
    sizes.sort()
    counts = 0
    for i in range(len(sizes) - 1):
        left = i + 1
        right = len(sizes) - 1
        temp = -1
        while left <= right:
            mid = (left + right) // 2
            if sizes[mid] * 0.9 <= sizes[i]:
                temp = mid
                left = mid + 1
            else:
                right = mid - 1
        counts += temp - i if temp > -1 else 0
    return counts


n = int(input().rstrip())
sizes = [int(num) for num in input().split()]
print(solution(sizes))
