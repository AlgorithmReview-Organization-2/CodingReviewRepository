#https://leetcode.com/problems/distinct-subsequences/

'''
1. 아이디어 :
    dfs로 두 갈래로 나눈다.
2. 시간복잡도 :
    O(n^2)
3. 자료구조 :
    배열
'''

class Solution:
    def numDistinct(self, s: str, t: str) -> int:
        dp = {}

        def dfs(i, j):
            if j==len(t):
                return 1
            if i==len(s):
                return 0
            if (i,j) in dp:
                return dp[(i,j)]

            if s[i]==t[j]:
                dp[(i,j)] = dfs(i+1, j) + dfs(i+1, j+1)
            else:
                dp[(i,j)] = dfs(i+1, j)

            return dp[(i,j)]

        return dfs(0,0)
