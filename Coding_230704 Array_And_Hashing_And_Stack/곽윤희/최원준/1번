# https://www.acmicpc.net/problem/10828

'''
1. 아이디어 :
    1) 스택을 사용하여 명령어를 처리.
2. 시간복잡도 :
    1) O(n) : n : 입력받은 명령어의 개수
3. 자료구조 :
    1) 스택
'''

import sys

n, ans = int(sys.stdin.readline()), []
for j in range(n):
    i = list(sys.stdin.readline().split())
    if i[0] == "push":
        ans.append(int(i[1]))
    elif i[0] == "pop":
        print(-1 if len(ans) == 0 else ans.pop())
    elif i[0] == "size":
        print(len(ans))
    elif i[0] == "empty":
        print(0 if ans else 1)
    elif i[0] == "top":
        print(ans[-1] if ans else -1)
