#https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/description/

'''
1. 아이디어 :
    dirr = key : set(val) 형식으로, 갈 수 있는 시작(key)과 도착(key)의 모음
    hmap = key : set(val) 형식으로, 연결되어 있는 모든 도시
    뿌리(0)부터 시작해서, 연결되어있는 도시들을(hmap[뿌리]) 하나씩 탐색하면서,
    도착할 수 있는 도시(dirr[연결 도시])가 존재하는지 확인한다.
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    해시맵
'''

from collections import defaultdict
class Solution:
    def minReorder(self, n: int, connections: List[List[int]]) -> int:

        dirr = {(a,b) for a,b in connections}
        hmap = { city:[] for city in range(n)}
        visited = set()
        self.ans = 0

        for c1, c2 in connections:
            hmap[c1].append(c2)
            hmap[c2].append(c1)

        def dfs(cprev):
            for cnext in hmap[cprev]:
                if cnext in visited:
                    continue
                if (cnext, cprev) not in dirr:
                    self.ans+=1
                visited.add(cnext)
                dfs(cnext)

        visited.add(0)
        dfs(0)

        return self.ans
