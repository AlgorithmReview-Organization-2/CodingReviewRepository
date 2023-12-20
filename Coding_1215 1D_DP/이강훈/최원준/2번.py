#https://school.programmers.co.kr/learn/courses/30/lessons/12971

'''
1. 아이디어 :
    house robber2와 같은 문제다.
    양쪽이 이어져있으므로, 배열을 두개로 나눈다.
    각 배열에서 prev, curr을 만들고 새로운 cmax를 연산한다.
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    배열
'''

def solution(sticker):

    def dp(nums):
        prev, curr = 0,0
        for n in nums:
            cmax = max(n+prev, curr)
            prev = curr
            curr = cmax
        return cmax

    s1 = sticker[1:]
    s2 = sticker[:-1]

    return max(dp(s1), dp(s2))
