# https://leetcode.com/problems/sudoku-solver/description/

'''
1. 아이디어 :
    해당 row,col의 숫자가 유효한지 확인하는 메서드를 통해서,
    row와 col을 돌면서 1~9까지의 숫자가 유효한지 확인하고 유효하면 넣고, 다음으로 넘어가는 방식으로 백트래킹을 수행
2. 시간복잡도 :
    O(9^81)
    1~9 숫자를 81번 넣어보는 경우의 수
3. 자료구조 :
    배열
'''

class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """

        def is_valid(row, col, num):
            for i in range(9):
                if board[row][i] == num:
                    return False
                if board[i][col] == num:
                    return False

            start_row = (row // 3) * 3
            start_col = (col // 3) * 3
            for i in range(3):
                for j in range(3):
                    if board[start_row + i][start_col + j] == num:
                        return False

            return True

        def backtrack():
            for row in range(9):
                for col in range(9):
                    if board[row][col] == ".":
                        for num in range(1, 10):
                            if is_valid(row, col, str(num)):
                                board[row][col] = str(num)
                                if backtrack():
                                    return True
                                board[row][col] = "."
                        return False
            return True

        backtrack()
