# https://www.acmicpc.net/problem/2206

'''
1. 아이디어 :
    bfs로 풀수 있다.
2. 시간복잡도 :
    O( n*m )
3. 자료구조 :
    배열
'''
from collections import deque
import sys

sys.setrecursionlimit(1000000)
input = sys.stdin.readline

n, m = list(map(int, input().split()))
grid = [list(input().rstrip()) for _ in range(n)]
print(grid)

dir = [(0, 1), (0, -1), (1, 0), (-1, 0)]

visited = [[[0] * 2 for _ in range(m)] for _ in range(n)]
visited[0][0][0] = 1
queue = deque()
queue.append((0, 0, 0))

while queue:
    row1, col1, broken = queue.popleft()
    if row1 == n-1 and col1 == m-1:
        print(visited[row1][col1][broken])
        exit()

    for row2, col2 in dir:
        nrow = row1 + row2
        ncol = col1 + col2
        if nrow <0 or nrow >= n or ncol < 0 or ncol >= m:
            continue

        if grid[nrow][ncol] == '1' and broken == 0:
            visited[nrow][ncol][1] = visited[row1][col1][0] + 1
            queue.append((nrow, ncol, 1))
        elif grid[nrow][ncol] == '0' and visited[nrow][ncol][broken] == 0:
            visited[nrow][ncol][broken] = visited[row1][col1][broken] + 1
            queue.append((nrow, ncol, broken))
print(-1)
