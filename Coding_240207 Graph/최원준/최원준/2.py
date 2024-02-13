# https://school.programmers.co.kr/learn/courses/30/lessons/49189

'''
1. 아이디어 :
    hmap을 만들어서 그래프를 만든다.
    bfs로 popleft를 통해 하나씩 꺼내오고, 그 노드의 인접 노드를 visited에 추가하면서 queue에 같이 추가한다.
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    해시맵, 큐, 해시셋
'''

from collections import deque
from collections import defaultdict
def solution(n, edge):
    hmap = defaultdict(set)
    for start, end in edge:
        hmap[start].add(end)
        hmap[end].add(start)

    visited = set()
    visited.add(1)
    distances = [float('inf')] * (n)
    distances[0] = 0

    queue = deque()
    visited = set()
    queue.append((0,1))
    visited.add(1)

    while queue:

        distance, node = queue.popleft()
        for n in hmap[node]:
            if n not in visited:
                visited.add(n)
                distances[n-1]=distances[node-1]+1
                queue.append((distance+1, n))

    return distances.count(max(distances))
