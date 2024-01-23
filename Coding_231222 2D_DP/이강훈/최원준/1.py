# https://school.programmers.co.kr/learn/courses/30/lessons/136797#

'''
1. 아이디어 :
    numbers의 길이가 길이가 100,000 이하 이므로, dp가 필요하다.
    left, right, idx를 저장한다.
2. 시간복잡도 :
    O(m^2)
3. 자료구조 :
    배열
'''

import sys
sys.setrecursionlimit(300_000)

def solution(numbers):
    weight = ((1, 7, 6, 7, 5, 4, 5, 3, 2, 3),
              (7, 1, 2, 4, 2, 3, 5, 4, 5, 6),
              (6, 2, 1, 2, 3, 2, 3, 5, 4, 5),
              (7, 4, 2, 1, 5, 3, 2, 6, 5, 4),
              (5, 2, 3, 5, 1, 2, 4, 2, 3, 5),
              (4, 3, 2, 3, 2, 1, 2, 3, 2, 3),
              (5, 5, 3, 2, 4, 2, 1, 5, 3, 2),
              (3, 4, 5, 6, 2, 3, 5, 1, 2, 4),
              (2, 5, 4, 5, 3, 2, 3, 2, 1, 2),
              (3, 6, 5, 4, 5, 3, 2, 4, 2, 1))

    dp = {}

    def dfs(left, right, idx):
        if idx == len(numbers):
            return 0
        if left == right:
            return float('inf')

        target = int(numbers[idx])

        if (left, right, idx) in dp:
            return dp[(left, right, idx)]

        left_v = dfs(target, right, idx+1) + weight[left][target]
        right_v =  dfs(left, target, idx+1) + weight[right][target]

        dp[(left, right, idx)] = min(left_v, right_v)
        return dp[(left, right, idx)]


    return dfs(4,6,0)
