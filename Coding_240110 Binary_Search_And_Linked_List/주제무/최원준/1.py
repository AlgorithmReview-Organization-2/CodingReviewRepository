# https://www.acmicpc.net/problem/20444 색종이와 가위

'''
1. 아이디어 :
    dfs로 풀려고 했는데 시간초과가 났다.
    row 가위질의 횟수를 이분탐색으로 하면 시간복잡도를 낮출 수 있다/
2. 시간복잡도 :
    O(logn)
3. 자료구조 :
    -
'''
import sys

sys.setrecursionlimit(1000000)
input = sys.stdin.readline


def solution(n, m):
    left = 0
    right = n // 2  # 원래는 n에서 부터 시작을 해야하지만, rowCut과 colCut이 (1,2)이든 (2,1) 이든 조각은 같기때문에 반까지만 돈다.

    while left <= right:
        rowCut = (left + right) // 2
        colCut = n - rowCut
        pieces = (rowCut + 1) * (colCut + 1)
        if m == pieces:
            return "Yes"
        if m > pieces:
            left = rowCut + 1
        else:
            right = rowCut - 1
    return "NO"


n, m = list(map(int, input().split()))

print(solution(n, m))

'''
def solution(n, m):
    def dfs(row, col, count, curr):
        if count > n or curr > m:
            return False
        if count == n and curr == m:
            return True

        return dfs(row*2, col, count+1, curr + row) or dfs(row, col*2, count+1, curr + col)

    ans = dfs(1, 1, 0, 1)
    return "YES" if ans else "NO"
'''
