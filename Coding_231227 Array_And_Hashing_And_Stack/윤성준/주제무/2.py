'''
https://www.acmicpc.net/problem/12904

주제: deque
시간복잡도: N

구현
B일 때 direction을 바꾼다
'''
from collections import deque


def forward(queue: deque):
    return queue.pop()

def backward(queue: deque):
    return queue.popleft()


S, T = input(), input()
count_down = len(T) - len(S)
T_q = deque(T)

direction = True
for _ in range(count_down):
    cur = None
    if direction:
        cur = forward(T_q)
    else:
        cur = backward(T_q)

    if cur == "B":
        direction = not direction
T = "".join(T_q)
if not direction:
    T = T[::-1]
print(int(S == T))
