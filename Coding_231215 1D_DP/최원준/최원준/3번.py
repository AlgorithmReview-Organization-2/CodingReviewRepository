# https://leetcode.com/problems/longest-palindromic-substring/description/


class Solution:
    def longestPalindrome(self, s: str) -> str:
        if s == s[::-1]:
            return s
        size = 1
        start = 0
        for idx in range(1, len(s)):
            left = idx - size
            right = idx + 1
            big = s[left - 1:right]
            lil = s[left:right]
            print(big,"/", lil)
            if big == big[::-1] and len(big) > size:
                size += 2
                start = left - 1
            elif lil == lil[::-1] and len(lil) > size:
                size += 1
                start = left

        return s[start:start+size]
