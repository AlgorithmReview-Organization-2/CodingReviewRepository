# https://leetcode.com/problems/find-eventual-safe-states/description/

'''
1. 아이디어 :
    dfs를 사용한다.
    safe node를 찾아야하는데 n번쨰 노드부터 시작해서 dfs를 돌린다.
    dfs메서드에서는 무한 루프를 방지하기 위해 조건문을 걸어놓고,
    safe하지 않는다고 가정을 한다음에 시작을 한다.
    노드의 이웃들이 safe하다면 해당 노드도 safe.
2. 시간복잡도 :
    O(edges + nodes)
3. 자료구조 :
    해시맵
'''

class Solution:
    def eventualSafeNodes(self, graph: List[List[int]]) -> List[int]:
        n = len(graph)
        safe = {}

        def dfs(i):
            if i in safe:
                return safe[i]
            safe[i] = False
            for neighbor in graph[i]:
                if not dfs(neighbor):
                    return False
            safe[i] = True
            return True

        res = []
        for i in range(n):
            if dfs(i):
                res.append(i)
        return res
