# https://leetcode.com/problems/rearrange-array-elements-by-sign/description/

'''
1. 아이디어 :
    정답으로 반환할 배열을 만들고, nums를 돌면서 짝수면 짝수번째 인덱스, 홀수면 홀수번째 인덱스에 넣는다.
2. 시간복잡도 :
    O(n) : n은 nums의 길이
3. 자료구조 :
    리스트

'''


class Solution:
    def rearrangeArray(self, nums: List[int]) -> List[int]:
        pos_idx=0
        neg_idx=1
        ans = [0 for x in range(len(nums))]
        for num in nums:
            if num>0:
                ans[pos_idx]=num
                pos_idx+=2
            else:
                ans[neg_idx]=num
                neg_idx+=2
        return ans
