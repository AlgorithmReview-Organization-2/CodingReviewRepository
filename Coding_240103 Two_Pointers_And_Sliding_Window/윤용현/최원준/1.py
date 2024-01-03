# https://leetcode.com/problems/container-with-most-water/description/

'''
1. 아이디어 :
    투포인터
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    배열
'''

class Solution:
    def maxArea(self, height: List[int]) -> int:

        def calc_area(left, right):
            return (right-left) * min(height[left], height[right])

        max_area, left, right = 0, 0, len(height)-1
        while left<right:
            max_area = max(max_area, calc_area(left, right))
            if height[left] > height[right]:
                right-=1
            else:
                left+=1
        return max_area
