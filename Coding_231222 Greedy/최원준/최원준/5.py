# https://leetcode.com/problems/minimum-replacements-to-sort-the-array/description/

'''
1. 아이디어 :
    맨 뒤에서부터 prev = nums[i], curr = nums[-1]로 두고,
    prev가 curr과 같거나 작으면 연산이 필요없으므로 그대로 둔다. curr = nums[i]
    prev % curr == 0이면, 딱 맞아 떨어지게 나눠지므로, curr은 똑같고, count만 증가한다. count+=prev//curr-1
    prev % curr != 0이면, 딱 맞아 떨어지지 않으므로, prev가 curr로 나눴을때 몇개의 숫자들로 구성되는지 저장(num_elements)하고, (7 -> [2,3,3])
    prev // num_elements 를 하게되면, curr보다 작은 숫자가 나오고, count에는 num_elements -1을 더해준다.
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    배열
'''

class Solution:
    def minimumReplacement(self, nums: List[int]) -> int:

        curr = nums[-1]
        count = 0

        for i in range(len(nums)-1,-1,-1):
            if nums[i] <= curr:
                curr = nums[i]
                continue

            if nums[i] % curr:
                num_elements = nums[i] // curr + 1
                curr = nums[i] // num_elements

            else:
                num_elements = nums[i] // curr


            count += num_elements - 1

        return count
