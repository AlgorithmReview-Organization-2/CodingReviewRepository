#https://leetcode.com/problems/next-permutation/description/

'''
1. 아이디어 :
    뒤에서부터 탐색하면서 최대값보다 높은 값이 나오면 배열에 저장하고 최대값을 갱신한다.
    최대 값보다 작은 값이 나오면, 그 값을 배열에 저장하고 배열을 정렬한다.
    그리고 배열에서 최대값보다 큰 값 중 가장 작은 값을 찾아서 그 값을 기존 nums배열에 저장한다.
    그리고 나머지 배열을 그대로 저장한다.
2. 시간복잡도 :
    O(nlogn)
3. 자료구조 :
    배열
'''

class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """

        stack = []
        cmax = 0

        while nums and nums[-1] >= cmax:
            num = nums.pop()
            stack.append(num)
            cmax = num

        if not nums:
            for n in stack:
                nums.append(n)
        else:
            num = nums.pop()
            stack.append(num)
            stack.sort()
            idx = 0
            while stack[idx] <= num:
                idx+=1
            nums.append(stack[idx])
            for i in range(len(stack)):
                if i!=idx:
                    nums.append(stack[i])

