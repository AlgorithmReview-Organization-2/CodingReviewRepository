# https://leetcode.com/problems/non-overlapping-intervals/

'''
1. 아이디어 :
    interval을 정렬한다.
    정렬 후에 prev_end와 next_start를 비교한다.
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    배열
'''

class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        intervals.sort()

        prev_end = intervals[0][1]
        ans = 0
        for next_start, next_end in intervals[1:]:
            if prev_end <= next_start:
                prev_end = next_end
            elif next_start < prev_end:
                ans += 1
                prev_end = min(prev_end, next_end)

        return ans


