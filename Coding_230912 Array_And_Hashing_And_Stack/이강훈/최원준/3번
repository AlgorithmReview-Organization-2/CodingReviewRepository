# https://www.acmicpc.net/problem/17298

'''
1. 아이디어 :
    정답 [-1 * n]을 만들고, 전 숫자를 스택에 저장해놓고, 새로운 숫자를 탐색하면서,
    새로운 숫자가 스택의 마지막 숫자보다 높을 경우
    마지막 숫자의 인덱스에 새로운 숫자를 입력한다.
    스택이 없어지거나, 스택의 마지막 숫자가 더 높을 경우, 새로운 숫자를 스택에 넣는다.
    이 부분을 반복한다.
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    배열(스택)
'''

stack = []
n = int(input())
nums = [[int(x), 0] for x in input().split()]
ans = [-1] * n
for i in range(len(nums)):
    nums[i][1] = i
print(nums)
for i in range(n):
    if not stack or stack[-1][0] >= nums[i][0]:
        stack.append(nums[i])
    else:
        while stack and stack[-1][0] < nums[i][0]:
            ans[stack[-1][1]] = nums[i][0]
            stack.pop()
        stack.append(nums[i])
print(*ans)
