# https://school.programmers.co.kr/learn/courses/30/lessons/12907

'''
1. 아이디어 :
    dp 문제
2. 시간복잡도 :
    O(n*m)
3. 자료구조 :
    배열
'''

def solution(n, money):
    dp = [1] + [0] * n
    for m in money:
        for i in range(m, n+1):
            dp[i] = (dp[i] + dp[i-m]) % 1000000007
    return dp[n]
