# https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description//

'''
1. 아이디어 :

2. 시간복잡도 :

3. 자료구조 :

'''

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        nums_set = set(nums)
        if target not in nums_set:
            return [-1,-1]

        ans = []
        left = 0
        right = len(nums)-1
        while left<=right:
            mid = (left+right)//2
            if nums[mid] < target:
                left = mid+1
            else:
                right = mid - 1
        ans.append(left)

        left = 0
        right = len(nums)-1
        while left<=right:
            mid = (left+right)//2
            if nums[mid] <= target:
                left = mid+1
            else:
                right = mid - 1
        ans.append(left-1)
        return ans
