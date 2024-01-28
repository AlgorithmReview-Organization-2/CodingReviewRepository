# https://www.acmicpc.net/problem/1967 트리의 지름

'''
1. 아이디어 :
    그래프에 [시작] = (끝, 거리)를 저장한다.
    dfs(시작)으로 각 시작의 끝, 거리에 따른 최대 길이를 개산한다
2. 시간복잡도 :
    O( n )
3. 자료구조 :
    해시맵
'''
import sys
from collections import defaultdict

sys.setrecursionlimit(1000000)
input = sys.stdin.readline

n = int(input().rstrip())


def solution(num):
    graph = defaultdict(set)
    ans = [0]

    for _ in range(n - 1):
        s, e, d = list(map(int, input().split()))
        graph[s].add((e, d))

    def dfs(root):
        if root not in graph:
            return 0

        children = graph[root]
        longest = 0
        longer = 0
        for child, dist in children:
            temp = dist + dfs(child)
            if temp > longest:
                longer = longest
                longest = temp
            elif temp > longer:
                longer = temp
        ans[0] = max(ans[0], longest + longer)
        return longest

    dfs(1)

    return ans[0]


print(solution(n))
