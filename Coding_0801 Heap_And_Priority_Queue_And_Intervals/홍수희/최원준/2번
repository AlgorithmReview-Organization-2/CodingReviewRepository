# https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts/

'''
1. 아이디어 :
    해시셋에 0이 아닌 숫자들을 넣고, 해시셋의 길이를 반환한다.
2. 시간복잡도 :
    O(N)
3. 자료구조 :
    해시셋
'''

class Solution:
    def minimumOperations(self, nums: List[int]) -> int:
        counts = set()
        for num in nums:
            if num != 0:
                counts.add(num)
        return len(counts)
