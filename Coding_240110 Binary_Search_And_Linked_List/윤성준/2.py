import sys
from collections import deque

input=sys.stdin.readline

# 시간이 얼마나 있든 풀 자신이 없어서
# 인터넷 100퍼 복붙입니다..
# dequeu에서 append pop O(1)

def main():
    n = int(input())
    for _ in range(n):
        s = input().rstrip()
        l = deque([])
        r = deque([])
        for i in s:
            if l and i == '-':
                l.pop()
            elif l and i == '<':
                r.appendleft(l.pop())
            elif r and i == '>':
                l.append(r.popleft())
            elif i != '<' and i != '>' and i != '-':
                l.append(i)

        print(''.join(l + r))

       
main()