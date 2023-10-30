# https://leetcode.com/problems/minimum-window-substring/description/

'''
1. 아이디어 :

2. 시간복잡도 :

3. 자료구조 :

'''

class Solution:
    def minWindow(self, s: str, t: str) -> str:

        def check(scount, tcount):
            for k,v in tcount.items():
                if k not in scount or scount[k] < v:
                    return False

            return True


        if len(t)>len(s):
            return ""

        scount = {}
        tcount = {}
        for i in range(len(t)):
            scount[s[i]] = 1 + scount.get(s[i],0)
            tcount[t[i]] = 1 + tcount.get(t[i],0)

        l=0
        r=len(t)-1
        ans = ""
        length = float('inf')
        while True:
            if check(scount, tcount) == False:
                r+=1
                if r==len(s):
                    break
                scount[s[r]] = 1 + scount.get(s[r],0)

            else:
                if length>len(s[l:r]):
                    ans = s[l:r+1]
                    length = len(ans)
                scount[s[l]] -= 1
                l+=1

        return ans
