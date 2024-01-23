# https://www.acmicpc.net/problem/3986

'''
1. 아이디어 :
    스택을 사용한다.
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    스택
'''

ans = 0
n = int(input())
for i in range(n):
    s = input()
    stack = []
    for c in s:
        if len(stack) == 0:
            stack.append(c)
        else:
            if c == "A":
                if stack[-1] == "B":
                    stack.append(c)
                else:
                    stack.pop()
            else:
                if stack[-1] == "A":
                    stack.append(c)
                else:
                    stack.pop()
        print(stack)
    if len(stack) == 0:
        ans += 1
print(ans)
