# https://www.acmicpc.net/problem/1306

'''
1. 아이디어 :
    최대값만 저장하고, index가 넘어갈때마다 popleft를 해준다.
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    deque
'''
from collections import deque

n, m = list(map(int, input().split()))
ads = list(map(int, input().split()))

q = deque()
l = r = 0
ans = []

while r < len(ads):
    while q and ads[q[-1]] < ads[r]:
        q.pop()
    q.append(r)

    if l > q[0]:
        q.popleft()

    if r + 1 >= m * 2 - 1:
        ans.append(str(ads[q[0]]))
        l += 1
    r += 1

print("".join(ans))
