# https://www.acmicpc.net/problem/1202 보석도둑

'''
1. 아이디어 :
    정렬을 해서, 가방에 들어갈 수 있는 보석들을 우선순위에 둔다.
    가방을 하나씩 꺼내면서, 가방에 들어갈 수 있는 보석들을 우선순위 큐에 넣는다.
    우선순위 큐에서 가장 가치가 높은 보석을 꺼내서 가방에 넣는다.
2. 시간복잡도 :
    O( nlogn )
3. 자료구조 :
    힙
'''
import heapq
import sys

sys.setrecursionlimit(1000000)
input = sys.stdin.readline

n, m = list(map(int, input().split()))
gem = []
for _ in range(n):
    weight, value = list(map(int, input().split()))
    gem.append((weight, value))
bag = []
for _ in range(m):
    bag.append(int(input().rstrip()))

gem.sort()
bag.sort()
temp = []
ans = 0
for b in bag:
    while gem and gem[0][0] <= b:
        heapq.heappush(temp, -heapq.heappop(gem)[1])
    if temp:
        ans += -heapq.heappop(temp)

print(ans)
