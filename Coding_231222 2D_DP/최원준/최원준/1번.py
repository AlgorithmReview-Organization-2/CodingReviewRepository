class Solution:
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        dp = {}

        dir =[[1,0],[-1,0],[0,1],[0,-1]]

        def dfs(r, c, prevVal):
            if r<0 or r==len(matrix) or c<0 or c == len(matrix[0]) or matrix[r][c]<=prevVal:
                return 0
            
            if (r,c) in dp:
                return dp[(r,c)]

            res = 1
            for r2, c2 in dir:
                res = max(res, 1+dfs(r+r2, c+c2, matrix[r][c]))
            dp[(r,c)] = res
            return res

        for r in range(len(matrix)):
            for c in range(len(matrix[0])):
                dfs(r,c,-1)
        return max(dp.values())
