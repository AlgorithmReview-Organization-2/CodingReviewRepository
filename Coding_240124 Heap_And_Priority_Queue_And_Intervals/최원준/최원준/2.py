# https://leetcode.com/problems/maximum-performance-of-a-team/

'''
1. 아이디어 :
    speed efficiency를 efficiency 기준으로 정렬시킨다.
    efficiency 기준으로 정렬하게 되면 speed의 값들중 가장 큰 k개 * efficiency 구하면된다.
    최소힙을 사용해서 가장 작은 걸 없애준다.
    예를 들어,
    5 3 1 5 7 4
    4 3 3 2 2 1
    일때, k = 2 라면,
    speed[i], efficiency[i]포문을 돌면서,
    i가 3이면, (5+3+1+5) * efficiency[3] 일때 가장 작은 efficiency 2개를 없애주면서 ans를 갱신하면 된다.
2. 시간복잡도 :
    O( nlogn )
3. 자료구조 :
    힙
'''

import heapq
class Solution:
    def maxPerformance(self, n: int, speed: List[int], efficiency: List[int], k: int) -> int:
        e = [(x1,x2) for x1, x2 in zip(speed, efficiency)]
        e = sorted(e, key = lambda p:p[1], reverse=True)

        minHeap = []
        total = 0
        ans = 0

        for speed, efficiency in e:
            total += speed
            heapq.heappush(minHeap, speed)

            if len(minHeap) > k:
                total -= heapq.heappop(minHeap)

            ans = max(ans, total * efficiency)

        return ans % (10**9 + 7)
