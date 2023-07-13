# https://leetcode.com/problems/rearrange-array-elements-by-sign/

'''
1. 아이디어 :
    투포인터로, 양수는 0, 음수는 1 부터 시작하여(index), 2씩 증가하면서 순서대로 넣어준다.
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    배열
'''


class Solution:
    def rearrangeArray(self, nums: List[int]) -> List[int]:
        ans, pos_idx, neg_idx = [0 for x in range(len(nums))], 0, 1
        for num in nums:
            if num > 0:
                ans[pos_idx] = num
                pos_idx += 2
            else:
                ans[neg_idx] = num
                neg_idx += 2
        return ans
