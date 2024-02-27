"""
https://www.acmicpc.net/problem/2225
"""
N, K = map(int, input().split())

dp = [[1] * (N+1)] + [[0] * (N+1) for _ in range(K-1)]

for k in range(1, K):
    for i in range(N+1):
        for j in range(N+1):
            if j-i >= 0:
                dp[k][j] += dp[k-1][j-i]
print(dp[-1][-1] % 1000000000)
