# https://leetcode.com/problems/evaluate-reverse-polish-notation/

'''
1. 아이디어 :
    스택을 사용한다.
2. 시간복잡도 :
    O(N)
3. 자료구조 :
    스택
'''

class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        for t in tokens:
            if t not in "+-*/":
                stack.append(int(t))
            else:
                right = stack.pop()
                left = stack.pop()
                if t == "+":
                    stack.append(left+right)
                elif t == "-":
                    stack.append(left-right)
                elif t == "*":
                    stack.append(left*right)
                elif t == "/":
                    stack.append(int(left/right))
        return stack[0]
