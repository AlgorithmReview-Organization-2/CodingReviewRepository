# https://leetcode.com/problems/rotting-oranges/description/

'''
1. 아이디어 :
    bfs로 풀 수 있다.
    큐(rotten)에 썩은 사과를 저장하고, fresh가 몇개인지 저장한다.
    rotten의 값을 하나씩 빼면서, 주변에 갈 수 있고, fresh 사과가 있으면,
    해당 좌표의 사과를 2로 바꾸고, rotten큐에 집어 넣고, fresh 값을 줄인다.
2. 시간복잡도 :
    n*n
3. 자료구조 :
    큐
'''

from collections import deque


class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        fresh = 0
        rotten = deque()
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    fresh += 1
                if grid[i][j] == 2:
                    rotten.append((i, j, 0))
        if fresh == 0:
            return 0

        dir = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        ctime = 0

        while rotten:
            row, col, time = rotten.popleft()
            ctime = time
            for row2, col2 in dir:
                new_row = row + row2
                new_col = col + col2
                if new_row < 0 or new_row >= len(grid) or new_col < 0 or new_col >= len(grid[0]):
                    continue
                if grid[new_row][new_col] == 1:
                    grid[new_row][new_col] = 2
                    rotten.append((new_row, new_col, time + 1))
                    fresh -= 1

        if fresh:
            return -1
        return ctime

        return 2342342
