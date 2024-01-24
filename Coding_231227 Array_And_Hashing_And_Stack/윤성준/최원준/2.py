# https://www.acmicpc.net/problem/

'''
1. 아이디어 :
    bfs를 사용하면 메모리 초과,
    dfs를 사용하면 시간 초과이다.
    dfs를 사용했을때 시간복잡도가 O(N^2)이므로
    O(N)으로 줄여야 하기떄문에 스택을 사용
2. 시간복잡도 :
    O(N)
3. 자료구조 :
    스택
'''
from collections import deque
import sys

input = sys.stdin.readline
start = input().rstrip()
end = input().rstrip()

while end:
    if start == end:
        print(1)
        exit(0)
    if end[-1] == "A":
        end = end[:-1]
    elif end[-1] == "B":
        end = end[:-1]
        end = end[::-1]

print(0)

