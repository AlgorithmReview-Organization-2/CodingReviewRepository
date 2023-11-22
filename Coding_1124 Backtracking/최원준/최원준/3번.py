# https://leetcode.com/problems/splitting-a-string-into-descending-consecutive-values/description/

'''
1. 아이디어 :
    백트래킹으로 풀 수 있다.
    '4321' 일때, 4, 43, 432까지 내려가면서 백트래킹
2. 시간복잡도 :
    O(n**n)
3. 자료구조 :
    문자열
'''


class Solution:
    def splitString(self, s: str) -> bool:

        def backtrack(prev, idx):
            if idx == len(s):
                return True

            for j in range(idx, len(s)):
                val = int(s[idx:j + 1])
                if prev - 1 == val and backtrack(val, j + 1):
                    return True

        for i in range(len(s) - 1):
            prev = int(s[:i + 1])
            if backtrack(prev, i + 1):
                return True
        return False
