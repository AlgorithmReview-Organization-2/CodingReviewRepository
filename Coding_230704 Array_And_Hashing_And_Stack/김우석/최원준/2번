# https://leetcode.com/problems/construct-smallest-number-from-di-string/description/

'''
1. 아이디어 :
    1부터 n+1까지의 숫자를 담은 배열을 만든다.
    p의 첫번째 문자가 I이면, ans에 n[0]을 추가하고, n, p를 각각 1칸씩 앞으로 당긴다
    p의 첫번째 문자가 D이면, 다음나올 i까지(또는 마지막) n을 뒤집어 ans에 추가하고, n, p를 각각 i+1칸씩 앞으로 당긴다
    위를 반복한다
2. 시간복잡도 :
    O(n^2)
3. 자료구조 :
    배열
'''



class Solution:
    def smallestNumber(self, p: str) -> str:
        ans=""
        n=[str(x) for x in range(1,len(p)+2)]
        while p:
            if p[0] == "I":
                ans += n[0]
                n, p = n[1:], p[1:]
            else:
                j=0
                while j<len(p) and p[j]=="D":
                    j+=1
                ans+="".join(n[:j+1][::-1])
                n, p = n[j+1:], p[j+1:]
        return ans+n[0] if n else ans

