#https://leetcode.com/problems/unique-paths/

'''
1. 아이디어 :
    - 2차 DP로 풀 수 있다.
2. 시간복잡도 :
    - O(m*n)
3. 자료구조 :
    - 배열
'''

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        grid = [[1] *n for i in range(m)]
        for i in range(1, m):
            for j in range(1, n):
                grid[i][j] = grid[i-1][j]+grid[i][j-1]
        return grid[-1][-1]
