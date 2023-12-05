# https://leetcode.com/problems/snakes-and-ladders/description/

'''
1. 아이디어 :
    각 자리마다 주사위를 굴렸을때 갈 수 있는 값들을 저장한다. (routes)
    path에 초기 (시작, 시간)을 저장하고,
    bfs를 통해서, routes[시작]안에 도착지들을 path에 다시 (도착, 시간+1)을 저장한다.
    재방문 하지 않도록 visited 해시셋을 만든다.
    도착을 하면 ans를 갱신한다.
    추가: ans보다 높은 time은 다시 path에 넣지 않게 최적화
2. 시간복잡도 :
    O(n*n)
3. 자료구조 :
    해시맵
'''

from collections import defaultdict
from collections import deque


class Solution:
    def snakesAndLadders(self, board: List[List[int]]) -> int:
        board = board[::-1]
        for i in range(len(board)):
            if i % 2 == 1:
                board[i] = board[i][::-1]

        hmap = defaultdict(int)
        for row in range(len(board)):
            for col in range(len(board[0])):
                hmap[row * len(board) + col + 1] = board[row][col]

        routes = defaultdict(set)
        for curr in range(len(board) ** 2):
            temp = -1
            for i in range(curr + 1, min(len(board) ** 2, curr + 6) + 1):
                if hmap[i] != -1:
                    routes[curr].add(hmap[i])
                if hmap[i] == -1:
                    temp = max(temp, i)
            if temp != -1:
                routes[curr].add(temp)

        visited = set()
        path = deque()
        path.append((1, 0))
        self.ans = float('inf')

        while path:
            start, time = path.popleft()
            if start == len(board) ** 2:
                self.ans = min(self.ans, time)
            else:
                visited.add(start)
                for dest in routes[start]:
                    if dest in visited:
                        continue
                    if time + 1 < self.ans:
                        path.append((dest, time + 1))

        return self.ans if self.ans != float('inf') else -1
