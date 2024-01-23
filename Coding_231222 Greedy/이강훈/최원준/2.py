# https://www.acmicpc.net/problem/1744

'''
1. 아이디어 :
    양수 0과 1을 제외한 나머지를 정렬 후, 큰 값끼리 묶는다.
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    배열
'''
import sys

input = sys.stdin.readline

n = int(input())

pos = []
neg = []

for _ in range(n):
    num = int(input())
    if num > 0:
        pos.append(num)
    else:
        neg.append(num)

pos.sort(reverse=True)
neg.sort()

ans = 0
while pos and (pos[-1] == 0 or pos[-1] == 1):
    ans += pos.pop()

for i in range(0, len(pos) - 1, 2):
    ans += pos[i] * pos[i + 1]
for i in range(0, len(neg) - 1, 2):
    ans += neg[i] * neg[i + 1]

if len(pos) % 2 == 1:
    ans += pos[-1]
if len(neg) % 2 == 1:
    ans += neg[-1]

print(ans)
