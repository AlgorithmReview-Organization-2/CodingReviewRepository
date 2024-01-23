# https://leetcode.com/problems/count-square-submatrices-with-all-ones/

'''
1. 아이디어 :
    1. [1][1] 부터 왼쪽, 위, 왼쪽위를 확인해서 네모가 나오는지 확인한다. 네모가 나오면 1을 더한다.
    2. 재귀로 돌리면서 dp로 저장한다.
2. 시간복잡도 :
    O(n**2)
3. 자료구조 :
    배열
'''


class Solution:
    def countSquares(self, m: List[List[int]]) -> int:

        r = len(m)
        c = len(m[0])
        total = 0
        for i in range(1, r) :
            for j in range(1, c) :
                if m[i][j] != 0 :
                    m[i][j] += min( m[i-1][j-1], m[i-1][j], m[i][j-1])

        for i in range(r) :
            for j in range(c) :
                total += m[i][j]

        return total
