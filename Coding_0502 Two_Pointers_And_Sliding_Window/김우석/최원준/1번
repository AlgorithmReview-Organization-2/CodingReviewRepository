# https://leetcode.com/problems/assign-cookies/description/

'''
1. 아이디어 :
    g, s를 오름차순으로 정렬한 후, g의 인덱스 gi와 s의 인덱스 si를 0으로 초기화한다.
    gi와 si를 증가시키면서 g[gi] <= s[si]인 경우 count를 증가시킨다.
2. 시간복잡도 :
    O(NlogN)
3. 자료구조 :
    배열
'''


class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        g.sort()
        s.sort()
        count = gi = si = 0

        while gi < len(g) and si < len(s):
            if g[gi] <= s[si]:
                count+=1
                gi+=1
            si+=1
        return count

