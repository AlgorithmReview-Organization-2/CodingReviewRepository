# https://leetcode.com/problems/edit-distance/

'''
1. 아이디어 :
    delete, insert, replace 세 가지 연산을 이용한다.
2. 시간복잡도 :
    O(n*m)
3. 자료구조 :
    해시맵
'''


class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        dp = {}

        def dfs(i, j):
            if i == len(word1):
                return len(word2) - j
            if j == len(word2):
                return len(word1) - i

            if (i, j) in dp:
                return dp[(i, j)]

            if word1[i] == word2[j]:
                dp[(i, j)] = dfs(i + 1, j + 1)
            else:
                dp[(i, j)] = 1 + min(dfs(i, j + 1), dfs(i + 1, j), dfs(i + 1, j + 1))

            return dp[(i, j)]

        return dfs(0, 0)
