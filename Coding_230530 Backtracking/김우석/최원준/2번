# https://leetcode.com/problems/combinations/

'''
1. 아이디어 :
    백트래킹을 사용. 인덱스를 매개변수로 재귀호출
2. 시간복잡도 :
    O(nCk)
3. 자료구조 :
    배열
'''

class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        ans = []
        nums = [i for i in range(1, n+1)]

        def backtrack(num_list, idx):
            if len(num_list)==k:
                ans.append(num_list.copy())
                return

            for i in range(idx, len(nums)):
                num_list.append(nums[i])
                backtrack(num_list, i+1)
                num_list.pop()

        backtrack([],0)
        return ans
