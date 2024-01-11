'''
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

주제:
시간복잡도: logN

구현
라이브러리를 사용하지 않고 구현
'''


class Solution:
    def searchRange(self, nums, target):
        result = self.binary_search_left(nums, target)
        if result >= 0:
            return [result, self.binary_search_right(nums, target)]
        else:
            return [-1, -1]

    def binary_search_left(self, nums, target):
        start, end = 0, len(nums)-1

        answer = None
        while start <= end:
            mid = (start+end) // 2

            if nums[mid] >= target:
                answer = mid
                end = mid-1
            else:
                start = mid+1
        return answer if answer is not None and nums[answer] == target else -1

    def binary_search_right(self, nums, target):
        start, end = 0, len(nums)-1

        answer = None
        while start <= end:
            mid = (start+end) // 2

            if nums[mid] <= target:
                answer = mid
                start = mid + 1
            else:
                end = mid-1
        return answer if answer is not None and nums[answer] == target else -1