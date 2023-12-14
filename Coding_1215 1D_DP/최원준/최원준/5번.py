# https://leetcode.com/problems/decode-ways/description/

'''
1. 아이디어 :
    dp로 풀 수 있다.
    첫째 숫자가 1~9이면, 다음 dp[i+1]을 결과에 추가하고,
    첫째, 둘째 숫자가 10~26이면 dp[i+2]를 추가한다.
2. 시간복잡도 :
    O(n^2)
3. 자료구조 :
    배열
'''

from collections import deque
class Solution:
    def numDecodings(self, s: str) -> int:
        dp = {len(s):1}

        def dfs(i):
            if i in dp:
                return dp[i]
            if s[i] == "0":
                return 0

            res = dfs(i+1)
            if (i+1<len(s) and (s[i] == "1" or s[i]=="2" and s[i+1] in "0123456")):
                res+=dfs(i+2)

            dp[i] = res
            return res

        a= dfs(0)
        print(dp)
        return a
