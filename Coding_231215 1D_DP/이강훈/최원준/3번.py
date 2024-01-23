# https://school.programmers.co.kr/learn/courses/30/lessons/161988

'''
1. 아이디어 :
    누적합이다.
    합을 구하면서 0보다 낮아지면 초기화를 하는 방식.
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    배열
'''


def solution(sequence):
    ans = 0
    s1 = 0
    s2 = 0
    pulse = 1

    for n in sequence:
        s1 += n * pulse
        s2 += n * -pulse

        ans = max(ans, s1, s2)

        s1 = max(0, s1)
        s2 = max(0, s2)

        pulse *= -1

    return ans
