# https://www.acmicpc.net/problem/11000

'''
1. 아이디어 :
    힙을 사용할 수 있다.
    시작, 끝 배열을 시작별로 정렬시킨다.
    하나씩 빼면서, end를 힙에 추가한다.
    힙의 제일 첫번째 원소가 start보다 작으면 pop하고,
    마지막으로 ans를 갱신한다.
2. 시간복잡도 :
    O(nlogn)
3. 자료구조 :
    힙, 배열
'''

import heapq
from collections import defaultdict

n = int(input())
classes = []
taken = defaultdict(int)
for i in range(n):
    classes.append(list(map(int, input().split())))
classes.sort(reverse=True)

cmax = 0
time = 0
while classes:
    cmax -= taken[time]
    while classes and classes[-1][0] == time:
        start, end = classes.pop()
        taken[end] += 1
        cmax += 1
    time += 1

print(cmax)
