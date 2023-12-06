# https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/

'''
1. 아이디어 :
    overlap 함수를 만들어서, 중복되는 문자가 있는지 확인한다.
    없으면, charSet에 추가하고, backtrack(i+1)을 호출한다.
    있으면, backtrack(i+1)을 호출한다.
2. 시간복잡도 :
    O(n^2)
3. 자료구조 :
    해시맵
'''

class Solution:
    def maxLength(self, arr: List[str]) -> int:
        charSet= set()

        def overlap(charSet, s):
            c = Counter(charSet) + Counter(s)
            return max(c.values()) > 1

        def backtrack(i):
            if i == len(arr):
                return len(charSet)

            res = 0
            if not overlap(charSet, arr[i]):
                for c in arr[i]:
                    charSet.add(c)
                res = backtrack(i+1)
                for c in arr[i]:
                    charSet.remove(c)

            return max(res, backtrack(i+1))

        return backtrack(0)
