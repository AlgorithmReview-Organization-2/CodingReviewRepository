# https://www.acmicpc.net/problem/2467

'''
1. 아이디어 :
    투 포인터 문제. abs(total)로 절대값이 0과 가까운 것만 추가하여 확인한다.
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    배열
'''

n = int(input())
nums = list(map(int, input().split()))

left, right, diff = 0, n-1, float('inf')

while left < right:
    total = nums[left] + nums[right]
    if abs(total) < diff:
        diff = abs(total)
        ans = [nums[left], nums[right]]
    if total > 0:
        right -= 1
    elif total < 0:
        left += 1
    elif total == 0:
        ans = [nums[left], nums[right]]
        break
print(*ans)
