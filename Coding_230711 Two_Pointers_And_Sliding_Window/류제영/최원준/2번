# https://www.acmicpc.net/problem/1806
'''
1. 아이디어 :
    1) lp=rp=0으로 설정 후, target보다 크거나 같으면 total-=nums[left]을 하고
     left+=1을 한 후 길이를 구하고(right-left+1) cmin을 갱신한다.
    작으면 total+=nums[right]로 갱신하고 rp+=1 한다.
2. 시간복잡도 :
    1) O(n)
3. 자료구조 :
    1) 배열
'''
import sys

n, target = map(int, input().split())
nums = list(map(int, input().split()))
left, right, total, cmin = 0, 0, nums[0], float('inf')

while True:
    if total >= target:
        total -= nums[left]
        cmin = min(cmin, right - left + 1)
        left += 1
    elif total < target:
        right += 1
        if right == n:
            break
        total += nums[right]

print(cmin if cmin != float('inf') else 0)
