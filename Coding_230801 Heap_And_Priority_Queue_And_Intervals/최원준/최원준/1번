#https://leetcode.com/problems/last-stone-weight/description/

'''
1. 아이디어 :
    % Prioirty queue를 구현하는게 heap이다.
    1) priority queue(heapq) 를 이용하여, 하나씩 뺴면서(heappop) x!=y일때 다시 삽입(heappush)을 한다,
2. 시간복잡도 :
    1) O(logn)
3. 자료구조 :
    1) Prioirty Queue
'''

import heapq
class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        print(stones)
        heapq.heapify(stones)
        hstones = []
        for stone in stones:
            heapq.heappush(hstones,(-stone, stone))

        while len(hstones)>=2:
            y = heapq.heappop(hstones)[1]
            x = heapq.heappop(hstones)[1]
            if y!=x:
                heapq.heappush(hstones, (-(y-x),(y-x)))
        return heapq.heappop(hstones)[1] if len(hstones)!=0 else 0
