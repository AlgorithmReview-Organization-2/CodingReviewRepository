# https://school.programmers.co.kr/learn/courses/30/lessons/42898#

'''
1. 아이디어 :
    1로 dp 초기화
    왼쪽, 위 dp에서 puddles이 있으면, 그 뒤까지의 dp를 0으로 만든다.
    나머지 puddles은 0으로 만든다.
    dp[y][x] = dp[y-1][x] + dp[y][x-1]
2. 시간복잡도 :
    O(n^2)
3. 자료구조 :
    배열
'''

def solution(m, n, puddles):
    dp = [[1 for _ in range(m)] for _ in range(n)]

    for x, y in puddles:
        if x == 1:
            for i in range(y - 1, n):
                dp[i][0] = 0
        if y == 1:
            for i in range(x - 1, m):
                dp[0][i] = 0

    for x, y in puddles:
        dp[y - 1][x - 1] = 0

    for y in range(1, n):
        for x in range(1, m):
            if dp[y][x] != 0:
                dp[y][x] = dp[y - 1][x] + dp[y][x - 1]

    return dp[-1][-1] % 1000000007
