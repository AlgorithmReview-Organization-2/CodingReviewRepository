# https://school.programmers.co.kr/learn/courses/30/lessons/92344

'''
1. 아이디어 :
    누적합으로 풀어야한다.
    1. 공격이면 -degree
    2. 회복이면 +degree
    3. 누적합을 구한다.
    4. board + 누적합이 1이상이면 살아남은 건물이다.
2. 시간복잡도 :
    O(n^2)
3. 자료구조 :
    배열
'''

def solution(board, skill):
    row = len(board)
    col = len(board[0])

    csum = [[0 for _ in range(col+1)] for _ in range(row+1)]

    count = 0

    for t, r1, c1, r2, c2, degree in skill:
        if t == 1: # 공격
            degree *=-1

        csum[r1][c1] += degree
        csum[r1][c2+1] -= degree
        csum[r2+1][c1] -= degree
        csum[r2+1][c2+1] += degree

    for row in range(len(csum)):
        for col in range(1, len(csum[0])):
            csum[row][col] = csum[row][col-1]+csum[row][col]

    for col in range(len(csum[0])):
        for row in range(1, len(csum)):
            csum[row][col] = csum[row-1][col]+csum[row][col]

    for row in range(len(board)):
        for col in range(len(board[0])):
            if board[row][col] + csum[row][col] >=1:
                count+=1

    return count
