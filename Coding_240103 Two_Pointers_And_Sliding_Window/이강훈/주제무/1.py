'''
https://www.acmicpc.net/problem/15961

주제: sliding window
시간복잡도: N

구현
circular 초밥을 저장하고 초기 초밥 고유 개수를 구한다.
투포인터로 끝과 끝을 제거, 추가한다.
cur_count를 둠으로 반복문이 2중화되지 않도록 한다.
쿠폰은 cur_count에 포함되지 않도록 구현한다.
'''
from collections import defaultdict
import sys
input = lambda: sys.stdin.readline().rstrip()


N, d, k, c = map(int, input().split())
sushis = [int(input()) for _ in range(N)]
sushis += sushis[:k]

# init calculate
cur_sushi = defaultdict(int)
for sushi in sushis[:k]:
    cur_sushi[sushi] += 1
check = True
for sushi in cur_sushi:
    if sushi == c:
        check = False
cur_count = len(cur_sushi)
max_count = cur_count+1 if check else cur_count

# calculate
p_1 = 0
for p_2 in range(k, N+k-1):
    s_1, s_2 = sushis[p_1], sushis[p_2]

    cur_sushi[s_1] -= 1
    if not cur_sushi[s_1]:
        cur_count -= 1

    if not cur_sushi[s_2]:
        cur_count += 1
    cur_sushi[s_2] += 1

    p_1 += 1
    max_count = max(max_count, cur_count+1 if not cur_sushi[c] else cur_count)

# print result
print(max_count)
