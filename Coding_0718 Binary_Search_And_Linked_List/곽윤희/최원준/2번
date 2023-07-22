# https://www.acmicpc.net/problem/1406

'''
1. 아이디어 :
- input을 리스트로 만들어서, 커서를 움직이며, 0이하일때는 "A"x, len(리스트)이상일떄는 "D"x
- list.insert()는 O(n)이라서 시간초과. 양쪽 배열을 만들고 append(O(1))를 한다
- list.pop()을 이용하여, 커서의 위치에 문자를 삭제한다.

2. 시간복잡도 :
- O(n) * O(1) = O(n)
- n : 명령반복수,
- 1 : list.insert(), list.pop(), 커서움직임의 시간복잡도
3. 자료구조 :
- 배열
'''

import sys

lstack = list(sys.stdin.readline().strip())
cursor = len(lstack)
rstack = []
for _ in range(int(sys.stdin.readline())):
    command = list(sys.stdin.readline().strip().split())
    if command[0] == "L" and lstack:
        rstack.append(lstack.pop())
    elif command[0] == "D" and rstack:
        lstack.append(rstack.pop())
    elif command[0] == "B" and lstack:
        lstack.pop()
    elif command[0] == "P":
        lstack.append(command[1])
print("".join(lstack+rstack[::-1]))
