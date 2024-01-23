# https://leetcode.com/problems/find-unique-binary-string/

'''
1. 아이디어 :
    백트래킹으로 풀 수 있다.
    재귀 함수를 통해 0 또는 1을 추가.
    bin_string길이가 nums의 첫번쨰 원소와 같다면, 해싯세에 존재하는지 확인.
    존재하지 않을 경우 return bin_string
2. 시간복잡도 :
    O(n) + O(2 ** 숫자길이)
3. 자료구조 :
    해시맵
'''


class Solution:
    def findDifferentBinaryString(self, nums: List[str]) -> str:
        bin_length = len(nums[0])
        nums = set(nums)
        candids = ["0", "1"]

        def backtracking(bin_string):
            if len(bin_string) == bin_length:
                if bin_string not in nums:
                    return bin_string
                else:
                    return None

            for c in candids:
                temp1 = backtracking(bin_string + c)
                if temp1:
                    return temp1

        return backtracking("")
