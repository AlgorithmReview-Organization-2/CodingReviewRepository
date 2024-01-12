# https://www.acmicpc.net/problem/1920

'''
1. 아이디어 :

2. 시간복잡도 :
    nlogn + logn
3. 자료구조 :

'''
import sys

sys.setrecursionlimit(1000000)
input = sys.stdin.readline


def solution(nums, target):
    left = 0
    right = len(nums) - 1
    while left <= right:
        mid = (left + right) // 2
        if nums[mid] == target:
            return 1
        elif nums[mid] > target:
            right = mid - 1
        else:
            left = mid + 1

    return 0


int(input().rstrip())
nums = sorted([int(num) for num in input().split()])
int(input().rstrip())
targets = [int(num) for num in input().split()]
for i in range(len(targets)):
    print(solution(nums, targets[i]))
