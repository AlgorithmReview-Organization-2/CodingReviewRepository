# https://leetcode.com/problems/search-in-rotated-sorted-array/description/

'''
1. 아이디어 :
    이분탐색 사용
    중간값 기준으로 피벗이 오른쪽에 있으면, nums[mid] <= nums[l] 충족
    반대로 중간값 기준으로 피벗이 왼쪽에 있으면, nums[mid] > nums[l] 충족

2. 시간복잡도 :
    O(logN)
3. 자료구조 :
    배열
'''


class Solution:
    def search(self, nums: List[int], target: int) -> int:

        l = 0
        r = len(nums) - 1

        while l <= r:
            mid = (l + r) // 2
            if target == nums[mid]:
                return mid
            #
            if nums[mid] >= nums[l]:
                if nums[l] <= target < nums[mid]:
                    r = mid - 1
                else:
                    l = mid + 1
            else:
                if nums[mid] < target <= nums[r]:
                    l = mid + 1
                else:
                    r = mid - 1

        return -1
