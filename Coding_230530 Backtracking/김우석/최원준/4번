# https://leetcode.com/problems/all-paths-from-source-to-target/description/

'''
1. 아이디어 :
    백트래킹을 사용. 목적지 도착하면 ans에 추가하고, 그게 아니면 path에 방문한 곳을 추가한 후 방문한 곳에서 다시 백트래킹을 수행
2. 시간복잡도 :
    O(nodes(=V)^2)
3. 자료구조 :
    배열
'''

class Solution:
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        ans = []
        path = [0]
        visited=set()


        def backtrack(idx):
            paths = graph[idx]
            if path[-1] == len(graph)-1:
                ans.append(path.copy())
                return

            for i in range(len(graph[idx])):
                path.append(graph[idx][i])
                backtrack(graph[idx][i])
                path.pop()

        backtrack(0)
        return ans
