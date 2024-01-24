# https://leetcode.com/problems/split-array-largest-sum/description/

'''
1. 아이디어 :
    이분탐색을 사용해서 largest sum을 가정하고 확인한다.
2. 시간복잡도 :
    O(slogn)
3. 자료구조 :
    배열
'''

class Solution:
    def splitArray(self, nums: List[int], k: int) -> int:

        def is_possible(largest, k):
            total = 0
            for i in range(len(nums)):
                if total+nums[i] <= largest:
                    total+=nums[i]
                else:
                    k-=1
                    total = nums[i]
                    if k<=0:
                        return False
            return True

        left = max(nums)
        right = sum(nums)
        ans = float('inf')
        while left<=right:
            mid = (left+right)//2
            if is_possible(mid, k):
                ans = min(ans, mid)
                right = mid - 1
            else:
                left = mid + 1

        return ans
