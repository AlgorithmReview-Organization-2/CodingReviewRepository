# https://www.acmicpc.net/problem/2003

'''
1. 아이디어 :
    투포인터로, total == m 일때 count를 하고,
    total이 m보다 크면, 왼쪽 포인터 값을 빼고, 포인터를 한칸 옮기고,
    total이 m보다 작으면, 오른쪽 포인터 값을 더하고, 포인터를 한칸 옮긴다.
    right == n+1 때까지 돈다.
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    배열
'''
import sys

input = sys.stdin.readline

n, m = map(int, input().split())
nums = list(map(int, input().split()))

left, right, count, total = 0, 1, 0, nums[0]

while right < n + 1:
    if right == n and total < m:
        break
    if total == m:
        count += 1
        total -= nums[left]
        left += 1

    elif total > m:
        total -= nums[left]
        left += 1

    elif total < m:
        total += nums[right]
        right += 1

print(count)
