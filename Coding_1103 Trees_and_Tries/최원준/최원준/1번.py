# https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/description/

'''
1. 아이디어 :
    그래프와 dfs를 사용하면 된다.
    그래프를 만든 후, 각 숫자안의 원소마다 dfs를 돈다.
    아래 노드들 중 hasApple이 있으면, 해당 노드를 가야하기때문에 +2를 하고, 리턴한다
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    배열
'''

class Solution:
    def minTime(self, n: int, edges: List[List[int]], hasApple: List[bool]) -> int:
        graph = { i: [] for i in range(n+1)}

        for edge in edges:
            graph[edge[0]].append(edge[1])
            graph[edge[1]].append(edge[0])

        def dfs(node, prev):
            total = 0
            for n in graph[node]:
                if n == prev:
                    continue
                childTime=dfs(n, node)
                if childTime or hasApple[n]:
                    total += 2+ childTime
            return total
        ans = dfs(0, None)
        return ans

