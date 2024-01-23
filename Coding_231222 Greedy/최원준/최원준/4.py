# https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/description/

'''
1. 아이디어 :
    covered=0으로 초기화하고, 최소 범위, 최대 범위중 covered보다 작은 ranges 중에 최대 범위를 covered로 갱신하면서 카운트 1증가.
    다시 최소 범위가 covered보다 작은 ranges 중 최대 범위를 covered로 갱신하면서 카운트 1증가.
    covered가 n보다 커지면 카운트 반환.

    배열을 초기화해서, 각 시작점[idx]에서 갈 수 있는 최대 범위를 저장한다.
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    배열
'''

from collections import deque


class Solution:

    def minTaps(self, n: int, ranges: List[int]) -> int:

        max_cover = [0] * (n + 1)
        for i in range(len(ranges)):
            cmin = max(0, i - ranges[i])
            cmax = i + ranges[i]
            max_cover[cmin] = max(max_cover[cmin], cmax)
        if max_cover[0] == 0:
            return -1

        count = 1
        covered = max_cover[0]
        left_idx = 1
        right_idx = covered
        while covered < n:
            for i in range(left_idx, right_idx + 1):
                covered = max(covered, max_cover[i])
            count += 1

            if right_idx == covered:
                return -1

            left_idx = right_idx
            right_idx = covered

        return count
