# https://leetcode.com/problems/valid-sudoku/description/

'''
1. 아이디어 :
    가로, 세로, 3x3 사각형을 검사해서 중복이 없으면 True를 리턴하고, 중복이 있으면 False를 리턴하는 함수를 만든다
    그 함수를 9x9 모든 칸에 대해 검사한다.
2. 시간복잡도 :
    O(9*9*9) = O(1)
3. 자료구조 :
    배열
'''

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:

        def isValid(x,y):
            target = board[x][y]
            for i in range(9):
                if board[x][i]==target:
                    if i!=y:
                        return False
                if board[i][y] == target:
                    if i!=x:
                        return False
            row = (x//3)*3
            col = (y//3)*3
            for i in range(row, row+3):
                for j in range(col, col+3):
                    if board[i][j] == target and i!=x and j!=y:
                        return False
            return True

        for i in range(9):
            for j in range(9):
                if board[i][j]!="." and not isValid(i,j):
                    return False
        return True

