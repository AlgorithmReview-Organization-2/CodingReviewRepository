# https://www.acmicpc.net/problem/2167

'''
1. 아이디어 :
    2차 DP로 누적합을 구하고,
    (x,y) - (x-1,y) - (x,y-1) + (x-1,y-1)을 구한다.
2. 시간복잡도 :
    O(N * M * cases)
3. 자료구조 :
    배열
'''

n, m = map(int, input().split())
arr = [[0 for _ in range(m + 1)]] + [[0] + list(map(int, input().split())) for _ in range(n)]

for i in range(1, n + 1):
    for j in range(1, m + 1):
        arr[i][j] = arr[i][j] + arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1]

for _ in range(int(input())):
    x1, y1, x2, y2 = map(int, input().split())
    print(arr[x2][y2] - arr[x1 - 1][y2] - arr[x2][y1 - 1] + arr[x1 - 1][y1 - 1])
