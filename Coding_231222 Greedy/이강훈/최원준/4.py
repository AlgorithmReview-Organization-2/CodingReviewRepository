# https://school.programmers.co.kr/learn/courses/30/lessons/42861

'''
1. 아이디어 :
    MST 알고리즘.
    시작점에서 갈 수 있는 지점들을 heapq에 넣는다.
    가장 거리가 짧은 지점으로 이동하고, 그 지점에서 갈 수 있는 지점들을 heapq에 넣는다.
    반복하면서 n-1개의 지점(visited의 갯수)을 방문하면 종료한다.
2. 시간복잡도 :
    O(E) *O(logE) = edges의 갯수 * heapq의 시간복잡도
3. 자료구조 :
    힙, 해시셋
'''
import heapq

def solution(n, costs):

    visited = set()
    min_heap = []
    heapq.heappush(min_heap, (0, 0))
    total_cost = 0

    while len(visited) < n:
        cost, destination = heapq.heappop(min_heap)
        if destination not in visited:
            visited.add(destination)
            total_cost += cost
            for i in range(len(costs)):
                if costs[i][0] == destination:
                    heapq.heappush(min_heap, (costs[i][2], costs[i][1]))
                elif costs[i][1] == destination:
                    heapq.heappush(min_heap, (costs[i][2], costs[i][0]))

    return total_cost

