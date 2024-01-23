'''
https://leetcode.com/problems/split-array-largest-sum/description/

주제: 이분 탐색
시간복잡도: logN

구현
유튜브 참고
'''
import bisect


class Solution:
    def splitArray(self, nums, k):
        min_sum = 0
        s, e = max(nums), sum(nums)
        while s <= e:
            mid = (s+e)//2

            cnt = 0
            cur_sum = 0
            for num in nums:
                if cur_sum + num > mid:
                    cnt += 1
                    cur_sum = num
                else:
                    cur_sum += num
            if cnt+1 <= k:
                min_sum = mid
                e = mid-1
            else:
                s = mid+1

        return min_sum
