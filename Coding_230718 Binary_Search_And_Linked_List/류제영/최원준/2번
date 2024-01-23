# https://www.acmicpc.net/problem/10816

'''
1. 아이디어 :
    1) 이분탐색
    2) 해시맵 이용
2. 시간복잡도 :
    1) O(m * logn)
    2) O(m + n)
3. 자료구조 :
    1) 배열
    2) 해시맵, 배열
'''

# 1)
from collections import Counter

n = int(input())
cards = sorted(list(map(int, input().split())))
m = int(input())
nums = list(map(int, input().split()))
counts = Counter(cards)


def binary_search(target):
    left = 0
    right = len(cards) - 1

    while left <= right:
        mid = (left + right) // 2

        if cards[mid] == target:
            return True
        elif cards[mid] > target:
            right = mid - 1
        elif cards[mid] < target:
            left = mid + 1
    return False


for i in range(len(nums)):
    if binary_search(nums[i]):
        nums[i] = str(counts[nums[i]])
    else:
        nums[i] = '0'

print(" ".join(nums))




# 2)
from collections import Counter

n = int(input())
cards = Counter(list(map(int, input().split())))
m = int(input())
print(" ".join([str(cards[num]) for num in list(map(int, input().split()))]))
