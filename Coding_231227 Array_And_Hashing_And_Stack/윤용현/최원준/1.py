# https://leetcode.com/problems/longest-consecutive-sequence/

'''
1. 아이디어 :
    visited 해시셋을 사용해서 중복 연산 되는것을 방지.
2. 시간복잡도 :
    O(N)
3. 자료구조 :
    해시셋
'''

class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        nums = set(nums)
        ans = 0
        visited = set()

        for n in nums:
            if n not in visited:
                i = 0
                while n + i in nums:
                    visited.add(n+i)
                    i+=1
                ans = max(ans, i)

        return ans
