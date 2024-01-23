# https://leetcode.com/problems/reverse-vowels-of-a-string/description/

'''
1. 아이디어 :
    스트링 s를 순회하면서 모음이면 reverse 배열에 추가하고, temp에 "<"로 넣는다..
    그리고 temp를 순회하면서 "<"모음">"이면 reverse 배열에서 pop하고, 아니면 temp의 문자를 그대로 추가한다.
2. 시간복잡도 :
    O(N)
3. 자료구조 :
    배열
'''


class Solution:
    def reverseVowels(self, s: str) -> str:
        vowels = "aeiouAEIOU"
        reverse = []

        temp = ans = ""
        for c in s:
            if c not in vowels:
                temp += c
            else:
                reverse.append(c)
                temp += "<"

        for c in temp:
            if c != "<":
                ans+=c
            else:
                ans+=reverse.pop()
        return ans
