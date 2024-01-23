# https://leetcode.com/problems/house-robber/description/

'''
1. 아이디어 :
    dp로 풀 수 있다.
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    배열
'''

class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums)==1:
            return nums[0]
        elif len(nums)==2:
            return max(nums)

        dp = [0, nums[0], max(nums[0],nums[1])]

        for i in range(3, len(nums)+1):
            dp.append(max( dp[i-2]+nums[i-1] , dp[i-1]))
        return dp[-1]


