# https://www.acmicpc.net/problem/1021

'''
1. 아이디어 :
    Deque를 이용하여 구현
2. 시간복잡도 :
    O(n^2)
3. 자료구조 :
    Deque
'''

from collections import deque
import sys

input = sys.stdin.readline

n, m = map(int, input().split())  # n : 큐의 크기, m : 뽑아내려는 수의 개수
pos = list(map(int, input().split()))  # 뽑아내려는 수의 위치
dq = deque([i for i in range(1, n + 1)])  # 1부터 n까지의 수를 deque에 넣음

count = 0 # 움직이는 횟수
for i in pos:
    while True:
        if dq[0] == i:
            dq.popleft()
            break
        else:
            if dq.index(i) < len(dq) / 2:
                while dq[0] != i:
                    dq.append(dq.popleft())
                    count += 1
            else:
                while dq[0] != i:
                    dq.appendleft(dq.pop())
                    count += 1
print(count)
