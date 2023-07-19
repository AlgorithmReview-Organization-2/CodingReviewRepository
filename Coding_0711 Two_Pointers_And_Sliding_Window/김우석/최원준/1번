# https://leetcode.com/problems/sort-colors/description/

'''
1. 아이디어 :
    3 포인터로 풀 수 있다.
    nums[p1]이 0일 경우, nums[p3]와 자리를 바꾸고, p1과 p2를 1씩 증가시킨다.
    nums[p1]이 2일 경우, nums[p3]와 자리를 바꾼다. p3를 1씩 감소시킨다.
    nums[p1]이 1일 경우, p1을 1씩 증가시킨다.
    p1 <= p3 일때 반복.
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    배열
'''


class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        p1, p2, p3 = 0, 0, len(nums) - 1

        while p1 <= p3:
            if nums[p1] == 0:
                nums[p1], nums[p2] = nums[p2], nums[p1]
                p2 += 1
                p1 += 1
            elif nums[p1] == 2:
                nums[p1], nums[p3] = nums[p3], nums[p1]
                p3 -= 1
            else:
                p1 += 1
