# https://www.acmicpc.net/problem/1253

'''
1. 아이디어 :
    이분탐색으로 i를 제외한 나머지 배열에서 i보다 작으면
    왼쪽 포인터를 +1, 반대면 오른쪽 포인터를 -1
    i가 나오면 +1, 아니면 +0
    위 작업을 nums안에 있는 모든 숫자에 대해 실행하면 된다.
2. 시간복잡도 :
    O(nlogn) (정렬 + n*이분탐색)
3. 자료구조 :
    배열
'''
import sys

n = int(sys.stdin.readline())
nums = sorted(list(map(int, sys.stdin.readline().split())))

count = 0


def binary_search(nums, idx):
    arr = nums.copy()
    target = arr.pop(idx)
    lp, rp = 0, len(arr) - 1
    while lp < rp:
        total = arr[lp] + arr[rp]
        if total > target:
            rp -= 1
        elif total < target:
            lp += 1
        else:
            return 1
    return 0


total = 0
for i in range(n):
    total += binary_search(nums, i)

print(total)

'''
[2, 3, 3, 4, 5, 5, 6, 6, 8, 9, 12, 15, 16]
[0 ,0, 0, 0, 1, 1, 1, 1, 1, 1, 1,  1,  1 ]

'''
