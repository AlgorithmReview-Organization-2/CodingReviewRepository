# https://www.acmicpc.net/problem/5397 키로거

'''
1. 아이디어 :

2. 시간복잡도 :

3. 자료구조 :

'''
import sys
sys.setrecursionlimit(1000000)
input = sys.stdin.readline


def solution(s):
    left = []
    right = []
    for c in s:
        if c == "<":
            if left:
                right.append(left.pop())
        elif c == ">":
            if right:
                left.append(right.pop())
        elif c == "-":
            if left:
                left.pop()
        else:
            left.append(c)
    while right:
        left.append(right.pop())

    return "".join(left)

n = int(input().rstrip())
for _ in range(n):
    s = input().rstrip()
    print(solution(s))
