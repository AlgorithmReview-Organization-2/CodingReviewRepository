# https://school.programmers.co.kr/learn/courses/30/lessons/49191

'''
1. 아이디어 :
    해시맵으로 이긴 사람수와 진 사람수가 n-1 이면 answer += 1
2. 시간복잡도 :
    O(n^2)
3. 자료구조 :
    해시맵
'''

from collections import defaultdict

def solution(n, results):
    winmap = defaultdict(set)
    losmap = defaultdict(set)

    for winner, loser in results:
        winmap[winner].add(loser)
        losmap[loser].add(winner)

    for i in range(1, n + 1):
        for loser in losmap[i]:
            winmap[loser].update(winmap[i])
        for winner in winmap[i]:
            losmap[winner].update(losmap[i])

    ans = 0
    for i in range(1, n + 1):
        if len(winmap[i]) + len(losmap[i]) == n - 1:
            ans += 1

    return ans
