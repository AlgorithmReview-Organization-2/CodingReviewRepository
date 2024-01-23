# https://school.programmers.co.kr/learn/courses/30/lessons/12952

'''
1. 아이디어 :
    전형적인 백트래킹 문제. 해시셋 세개로 갈 수 없는 곳을 트래킹한다
2. 시간복잡도 :
    O(n**n)
3. 자료구조 :
    해시셋
'''

def solution(n):
    column = set()
    posDiag = set()
    negDiag = set()

    ans = [0]
    def backtrack(row):
        if row==n:
            ans[0]+=1
            return

        for col in range(n):
            pos = col+row
            neg = col-row
            if pos not in posDiag and neg not in negDiag and col not in column:
                posDiag.add(pos)
                negDiag.add(neg)
                column.add(col)
                backtrack(row+1)
                posDiag.remove(pos)
                negDiag.remove(neg)
                column.remove(col)

    backtrack(0)
    return ans[0]
