# https://www.acmicpc.net/problem/14246

'''
1. 아이디어 :
    투 포인터로 left=0, right=0 으로 시작
    total이 k보다 높으면 nums의 길이 - right + 1 을 ans에 더하고, left 포인터를 하나 옮기면서 nums[left]를 뺸다.
    total이 k보다 작으면 right 포인터를 옮기면서 더한다.
    중간에 right이 nums의 길이보다 커지면 break
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    배열
'''
length = int(input())
nums = list(map(int, input().split()))
k = int(input())

left, right, total, ans = 0, 0, 0, 0

while 1:
    if total > k:
        ans += len(nums) - right + 1
        total -= nums[left]
        left += 1
    elif right == len(nums):
        break
    else:
        total += nums[right]
        right += 1
print(ans)
