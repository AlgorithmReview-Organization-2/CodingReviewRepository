# https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/description/

'''
1. 아이디어 :
    백트래킹으로 풀려다가 아닌것 같아서 정답 확인.
    슬라이딩 윈도우로 sum-x 를 찾으면 된다.
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    배열
'''


class Solution:
    def minOperations(self, nums: List[int], x: int) -> int:
        target = sum(nums) - x
        if target == 0:
            return len(nums)

        left = right = 0

        ans = -1
        total = nums[left]
        while left < len(nums) and right < len(nums):
            if total == target:
                ans = max(ans, right - left + 1)
                total -= nums[left]
                left += 1
                right += 1
                if right == len(nums):
                    break
                total += nums[right]
            elif total < target:
                right += 1
                if right == len(nums):
                    break
                total += nums[right]
            else:
                total -= nums[left]
                left += 1

        return -1 if ans == -1 else len(nums) - ans
