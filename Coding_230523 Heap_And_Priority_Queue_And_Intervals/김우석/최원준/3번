# https://leetcode.com/problems/sum-in-a-matrix/description/

'''
1. 아이디어 :
    최소힙을 사용하여 각 행을 힙으로 만든 후, 각 행에서 작은 수부터 뽑아낸다. (큰거와 작은거 순서 차이 x)
2. 시간복잡도 :
    O(n) * O(logn) + O(n) * O(logn) = O(nlogn)
    각 행을 힙으로 만들기 + 각 행에서 작은 수부터 뽑아내기
3. 자료구조 :
    힙

'''

import heapq
class Solution:
    def matrixSum(self, nums: List[List[int]]) -> int:
        for num in nums:
            heapq.heapify(num)
        ans = 0

        for i in range(len(nums[0])):
            cmax = 0
            for num in nums:
                cmax = max(cmax, heapq.heappop(num))
            ans += cmax
        return ans

