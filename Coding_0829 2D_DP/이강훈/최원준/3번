# https://www.acmicpc.net/problem/12865

'''
1. 아이디어 :
    1차 DP 2개로 구현
    존재하는 idx를 모아두는 set와 dp를 이용해서 조금 더 빠르게 구현
2. 시간복잡도 :
    O(N * K)
3. 자료구조 :
    배열, 해시셋
'''

n, k = map(int, input().split())  # n개의 물건
dp = [0] * (k + 1)
exist = set()
for _ in range(n):
    prev = dp.copy()
    w, v = map(int, input().split())
    temp = []
    for weight in exist:
        if weight + w <= k:
            dp[weight + w] = max(prev[weight + w], prev[weight] + v)
            temp.append(weight + w)
    for n in temp:
        exist.add(n)
    if w <= k:
        dp[w] = max(dp[w], v)
        exist.add(w)
print(max(dp))

