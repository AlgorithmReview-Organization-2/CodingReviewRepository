# https://leetcode.com/problems/valid-parenthesis-string/description/

'''
1. 아이디어 :
    dp로 풀 수 있다. 시간복잡도 n^3.
    더 빠르게 그리디를 사용한다.
    열린 괄호의 최소, 최대 개수를 저장한다.
    열린 괄호의 최소 개수가 0보다 작으면 0으로 초기화를 한다.
    열린 괄호의 최대 개수가 0보다 작아지면 False를 반환한다.
    모든 문자열을 돌고, 열린 괄호의 최소 개수가 0보다 크면 False를 반환한다.
    그 외, True를 반환한다.
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    배열
'''


class Solution:
    def checkValidString(self, s: str) -> bool:

        left_min, left_max = 0, 0

        for c in s:
            if c == "(":
                left_max += 1
                left_min += 1
            elif c == ")":
                left_max -= 1
                left_min -= 1
            elif c == "*":
                left_max += 1
                left_min -= 1

            left_min = max(left_min, 0)

            if left_max < 0:
                return False

        if left_min > 0:
            return False

        return True
