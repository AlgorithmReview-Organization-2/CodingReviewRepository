# https://leetcode.com/problems/minimum-swaps-to-make-strings-equal/description/

'''
1. 아이디어 :
    s1와 s2에서 서로 다른 값일 경우 xy, yx를 카운트한다.
    xy와 yx의 합이 홀수면 같은게 만들어질 수 없으므로 -1을 리턴하고,
    x와 y를 서로 바꿔주고 마지막 xx, yy가 남게되는 경우 2번을 바꿔줘야하므로, %2를 통해 2로 나눈 나머지를 더한다.
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    배열
'''

class Solution:
    def minimumSwap(self, s1: str, s2: str) -> int:
        xy=0
        yx=0
        for i in range(len(s1)):
            if s1[i] != s2[i]:
                if s1[i]=="x":
                    xy+=1
                else:
                    yx+=1

        if (xy+yx) % 2 == 1:
            return -1

        ans = xy//2 + yx//2
        if xy %2 == 1:
            ans+=2
        return ans
