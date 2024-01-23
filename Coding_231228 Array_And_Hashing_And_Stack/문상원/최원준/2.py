# https://www.acmicpc.net/problem/17298

'''
1. 아이디어 :
    monotonic stack을 사용
2. 시간복잡도 :
    O(N)
3. 자료구조 :
    스택
'''
import sys

input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))

stack = []
ans = [-1] * n
for i in range(len(arr)):
    while stack and stack[-1][0] < arr[i]:
        num, idx = stack.pop()
        ans[idx] = arr[i]
    stack.append([arr[i], i])

print(*ans)
