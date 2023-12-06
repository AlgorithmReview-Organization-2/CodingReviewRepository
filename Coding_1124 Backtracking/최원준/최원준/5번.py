# https://leetcode.com/problems/n-queens-ii/description/

'''
1. 아이디어 :
    해시맵 3개로 갈 수 없는 곳들을 체크한다.
    posDiag는 row + col, negDiag는 row-col, column은 col
    마지막 row+1에 도착하면 카운트를 하나 올린다.
2. 시간복잡도 :
    O(n^n)
3. 자료구조 :
    해시셋
'''

class Solution:
    def totalNQueens(self, n: int) -> int:

        column = set()
        posDiag = set()
        negDiag = set()

        self.ans = 0

        def backtrack(row):
            if row == n:
                self.ans += 1
                return

            for col in range(n):
                pos = row+col
                neg = row-col
                if pos not in posDiag and neg not in negDiag and col not in column:
                    posDiag.add(pos)
                    negDiag.add(neg)
                    column.add(col)
                    backtrack(row+1)
                    posDiag.remove(pos)
                    negDiag.remove(neg)
                    column.remove(col)

        backtrack(0)
        return self.ans
