# https://leetcode.com/problems/house-robber-ii/description/

'''
1. 아이디어 :
    dp로 풀 수 있다
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    배열
'''


class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        nums1 = nums[1:]
        nums2 = nums[:-1]

        def dynamic(nums):
            prev, curr = 0, 0
            for n in nums:
                cmax = max(n + prev, curr)
                prev = curr
                curr = cmax
            return cmax

        return max(dynamic(nums1), dynamic(nums2))
