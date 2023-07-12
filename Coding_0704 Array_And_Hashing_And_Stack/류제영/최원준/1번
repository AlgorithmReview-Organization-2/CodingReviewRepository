# https://www.acmicpc.net/problem/9012

'''
1. 아이디어 :
    "()"을 하나씩 지우고 남은 문자열이 없으면 YES, 있으면 NO
2. 시간복잡도 :
    O(n^2)
3. 자료구조 :
    문자열
'''

import sys

n = int(sys.stdin.readline())
for i in range(n):
    s = sys.stdin.readline().rstrip()
    for i in range(50):
        s = s.replace("()", "")
        if s == "":
            break
    print("YES" if s == "" else "NO")


