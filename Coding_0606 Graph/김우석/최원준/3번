# https://leetcode.com/problems/number-of-provinces/

'''
1. 아이디어 :
    1) dfs로 풀수 있다
    2) union find로 풀 수 있다.
2. 시간복잡도 :
    1) O(N^2)
    2) O(N^2)
3. 자료구조 :
    1) 그래프
    2) 그래프
'''
#1)
class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        n = len(isConnected)
        visited = [False] * n
        provinces = 0

        # use depth first search
        def dfs(node):
            visited[node] = True
            for neighbor in range(n):
                if isConnected[node][neighbor] == 1 and not visited[neighbor]:
                    dfs(neighbor)

        for i in range(n):
            if not visited[i]:
                provinces += 1
                dfs(i)

        return provinces

#2
class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        edges, par, rank = [], [], []
        for i in range(len(isConnected)):
            par.append(i)
            rank.append(1)

        for i in range(len(isConnected)):
            for j in range(i, len(isConnected)):
                if i!=j and isConnected[i][j]==1:
                    edges.append([i, j])

        def find(n1):
            res = n1
            while res != par[res]:
                par[res] = par[par[res]]
                res = par[res]
            return res

        def union(n1, n2):
            p1, p2 = find(n1), find(n2)

            if p1==p2:
                return 0

            if rank[p2] > rank[p1]:
                par[p1] = p2
                rank[p2] +=1
            else:
                par[p2] = p1
                rank[p1] +=1
            return 1

        ans = len(isConnected)
        for n1, n2 in edges:
            ans-=union(n1, n2)


        return ans
