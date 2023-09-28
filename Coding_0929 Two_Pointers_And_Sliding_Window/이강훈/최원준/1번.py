# https://www.acmicpc.net/problem/1522

'''
1. 아이디어 :
    A의 길이만큼 슬라이딩 윈도우
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    문자열
'''

from collections import Counter
s = input().strip()
countb = 0
ans = float('inf')

l, r = 0, s.count('a')-1
for i in range(r+1):
    if s[i] == 'b':
        countb += 1

s += s
while r < len(s)-1:
    if s[l] == "b":
        countb -= 1
    l += 1
    r += 1
    if s[r] == "b":
        countb += 1
    ans = min(ans, countb)

print(ans)
