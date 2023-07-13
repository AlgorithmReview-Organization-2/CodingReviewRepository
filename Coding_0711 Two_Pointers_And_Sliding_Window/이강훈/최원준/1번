# https://www.acmicpc.net/problem/2559

'''
1. 아이디어 :
    슬라이딩 윈도우 문제
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    배열
'''


n, k = map(int, input().split())
nums = list(map(int, input().split()))
left, right = 0, k
ans = cmax = sum(nums[:k])
while right < n:
    ans = ans - nums[left] + nums[right]
    cmax = max(ans, cmax)
    left += 1
    right += 1
print(cmax)
