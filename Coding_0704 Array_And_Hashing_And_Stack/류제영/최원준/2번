# https://www.acmicpc.net/problem/4949

'''
1. 아이디어 :
    ([])을 따로 저장하고, [], ()을 지우면서 남은 문자열이 없으면 yes, 있으면 no
2. 시간복잡도 :
    O(n^2)
3. 자료구조 :
    문자열
'''

import sys

while True:
    s = sys.stdin.readline().rstrip()
    if s == ".":
        break
    ns = ""
    for i in s:
        if i in "([)]":
            ns += i
    for i in range(100):
        ns = ns.replace("()", "")
        ns = ns.replace("[]", "")
        if ns == "":
            break
    print("yes" if ns == "" else "no")
