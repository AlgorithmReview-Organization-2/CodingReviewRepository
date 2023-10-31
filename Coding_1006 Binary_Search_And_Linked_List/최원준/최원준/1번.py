# https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

'''
1. 아이디어 :
    이분탐색 사용
    중간이 오른쪽 값보다 크면, 오름차순이 아니므로, 중간값을 올린다.
    중간이 오른쪽 값보다 작으면, 오름차순이므로, 중간값을 내린다.

2. 시간복잡도 :
    O(logN)
3. 자료구조 :
    배열
'''


class Solution:
    def findMin(self, nums: List[int]) -> int:

        if nums[0] <= nums[-1]:
            return nums[0]

        l = 0
        r = len(nums) - 1

        while l < r:
            mid = (l + r) // 2
            if nums[mid] > nums[r]:
                l = mid + 1
            else:
                r = mid
        return nums[l]
