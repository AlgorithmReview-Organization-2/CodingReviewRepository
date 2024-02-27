"""
https://www.acmicpc.net/problem/2565
"""
n, k = map(int, input().split())
coins = [coin for coin in [int(input()) for _ in range(n)] if coin <= k]

dp = [0] * (k+1)
for coin in coins:
    dp[coin] += 1
    for i in range(coin, k+1):
        dp[i] += dp[i-coin]
print(dp[-1])