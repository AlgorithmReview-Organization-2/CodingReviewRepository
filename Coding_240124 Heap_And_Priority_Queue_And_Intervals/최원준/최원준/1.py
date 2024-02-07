# https://leetcode.com/problems/maximum-subsequence-score/

'''
1. 아이디어 :
    nums1과 num2를 nums2 기준으로 정렬시킨다.
    nums2 기준으로 정렬하게 되면 nums1의 값들중 가장 큰 k개 * nums2를 구하면된다.
    최소힙을 사용해서 가장 작은 걸 없애준다.
    예를 들어,
    5 3 1 5 7 4
    4 3 3 2 2 1
    일때, k = 2 라면,
    nums1[i], nums2[i]포문을 돌면서,
    i가 3이면, (5+3+1+5) * nums2[3] 일때 가장 작은 nums2 2개를 없애주면서 ans를 갱신하면 된다.
2. 시간복잡도 :
    O( nlogn )
3. 자료구조 :
    힙
'''

import heapq
class Solution:
    def maxScore(self, nums1: List[int], nums2: List[int], k: int) -> int:
        scores = [(x1, x2) for x1, x2 in zip(nums1, nums2)]
        scores = sorted(scores, key=lambda p: p[1], reverse=True)

        total = 0
        minHeap = []
        ans = 0
        for x1, x2 in scores:
            total += x1
            heapq.heappush(minHeap, x1)

            if len(minHeap) > k:
                total -= heapq.heappop(minHeap)

            if len(minHeap) == k:
                ans = max(ans, total * x2)

        return ans
