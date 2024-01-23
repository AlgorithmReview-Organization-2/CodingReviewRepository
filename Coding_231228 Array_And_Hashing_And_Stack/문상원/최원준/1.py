# https://www.acmicpc.net/problem/1874

'''
1. 아이디어 :
    스택을 사용한다.
    current_number를 1부터 시작해서 target_number까지 증가시키거나, 스택의 top이 target_number와 같으면 pop한다.
    current_number가 target_number보다 크고 스택의 top이 target_number와 다르면 No를 출력하고 종료한다.
2. 시간복잡도 :
    O(N)
3. 자료구조 :
    스택
'''
import sys

input = sys.stdin.readline

stack = []
curr = 1
ans = []
for _ in range(int(input())):
    target = int(input())
    while curr <= target:
        stack.append(curr)
        curr += 1
        ans.append("+")
    if stack[-1] == target:
        stack.pop()
        ans.append("-")
    else:
        print("NO")
        exit(0)
print("\n".join(ans))

