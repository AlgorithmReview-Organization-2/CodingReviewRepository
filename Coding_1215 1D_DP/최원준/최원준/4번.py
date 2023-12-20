# https://leetcode.com/problems/palindromic-substrings/

'''
1. 아이디어 :
    i번째 캐릭터부터 양쪽으로 뻗어나간다.
    홀짝수 palindrome 둘다 체크한다.
2. 시간복잡도 :
    O(n^2)
3. 자료구조 :
    배열
'''

class Solution:
    def countSubstrings(self, s: str) -> int:

        def count_pal(idx,left,right,s):
            count=0
            while left>=0 and right<len(s) and s[left]==s[right]:
                count+=1
                left-=1
                right+=1
            return count

        ans = 0
        for i in range(len(s)):
            ans+=count_pal(i,i,i,s)
            ans+=count_pal(i,i,i+1,s)

        return ans
