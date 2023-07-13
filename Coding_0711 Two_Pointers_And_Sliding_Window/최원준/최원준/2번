# https://leetcode.com/problems/maximum-average-subarray-i/

'''
1. 아이디어 :
    슬라이딩 윈도우. k까지의 합을 구하고, 맨 처음을 빼고, 맨 마지막의 다음 숫자를 더해서 비교한다.
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    배열
'''


class Solution:
    def findMaxAverage(self, nums: List[int], k: int) -> float:
        ans = cmax = sum(nums[:k])
        for i in range(len(nums) - k):
            cmax = cmax - nums[i] + nums[k + i]
            ans = max(ans, cmax)
        return ans / k
