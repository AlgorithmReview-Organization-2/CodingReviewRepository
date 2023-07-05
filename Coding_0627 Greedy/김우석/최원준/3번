# https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/description/

'''
1. 아이디어 :
    스택을 사용해서, "("가 나오면 스택에 넣는다.
    ")"가 나오면 스택의 top이 "("이면 pop, 아니면 push
    스택에 남아있는 값이 최소로 추가해야하는 값이다.
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    배열(스택)
'''


class Solution:
    def minAddToMakeValid(self, s: str) -> int:
        stack = []
        for b in s:
            if b == "(":
                stack.append(b)
            else:
                if len(stack) == 0 or stack[-1] != "(":
                    stack.append(b)
                else:
                    stack.pop()

        return len(stack)
