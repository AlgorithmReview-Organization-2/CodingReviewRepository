# https://www.acmicpc.net/problem/1072

import sys
g, y = map(int, sys.stdin.readline().split())
target = ((y * 100) // g ) + 1
if target >= 100:
    print(-1)
else:
    start, end = 0, 1000000000
    while start <= end:
        mid = (start + end) // 2
        if ((y+mid) * 100)//(g+mid) >= target:
            end = mid - 1
        else:
            start = mid + 1
    print(start)
