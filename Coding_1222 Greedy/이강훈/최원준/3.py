# https://www.acmicpc.net/problem/2812

'''
1. 아이디어 :
    k번째까지 앞에서 큰 수만 남겨놓고, k와 num을 갱신하는 방식을 사용했었는데 실패.
    Stack을 사용해서 앞에 있는 수가 뒤에 있는 수보다 작으면 pop하고, k를 1 감소시키는 방식으로 해결.
    마지막에 k가 0보다 크면 뒤에서부터 k개를 제거한다.
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    스택
'''
import sys

n, k = map(int, sys.stdin.readline().split())
K= k
nums = list(input())
stack = []

for i in range(n):
    while k>0 and stack and stack[-1] < nums[i]:
        stack.pop()
        k -= 1
    stack.append(nums[i])

print(''.join(stack[:n-K]))

