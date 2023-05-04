#https://leetcode.com/problems/roman-to-integer/description/

'''
1. 아이디어 :
    해시맵으로 풀 수 있다. 모든 경우의 수를 매핑하기보단, 7가지 경우만 매핑하고, 나머지는 replace로 처리하면 더 빠르게 풀 수 있다.
2. 시간복잡도 :
    O(n) : n은 s의 길이
3. 자료구조 :
    해시맵
'''


class Solution:
    def romanToInt(self, s: str) -> int:
        ans = 0
        values = {
            "I" : 1,
            "V" : 5,
            "X" : 10,
            "L" : 50,
            "C" : 100,
            "D" : 500,
            "M" : 1000
        }
        print(values)
        s=s.replace("IV","IIII").replace("IX","VIIII").replace("XL","XXXX").replace("XC","LXXXX").replace("CD","CCCC").replace("CM","DCCCC")
        for char in s:
            ans+=values[char]

        return ans
