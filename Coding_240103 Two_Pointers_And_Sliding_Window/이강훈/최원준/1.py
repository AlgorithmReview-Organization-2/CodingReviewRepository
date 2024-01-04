# https://www.acmicpc.net/problem/15961

'''
1. 아이디어 :
     슬라이딩 윈도우와 카운트, 해시맵을 사용
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    배열, 해시맵
'''
from collections import defaultdict
import sys

sys.setrecursionlimit(1000000)
input = sys.stdin.readline


def solution(sushi, length, coupon):
    sushi += sushi
    hmap = defaultdict(int)
    hmap[coupon] += 1
    kinds = 1
    ans = 1
    left = 0
    for right in range(length):
        hmap[sushi[right]] += 1
        if hmap[sushi[right]] == 1:
            kinds += 1
    ans = max(ans, kinds)
    right += 1
    while right < len(sushi):
        hmap[sushi[right]] += 1
        if hmap[sushi[right]] == 1:
            kinds += 1
        hmap[sushi[left]] -= 1
        if hmap[sushi[left]] == 0:
            kinds -= 1
        left += 1
        right += 1
        ans = max(ans, kinds)

    return ans


n, kinds, k, coupon = list(map(int, input().split()))
sushi = []
for _ in range(n):
    sushi.append(int(input()))
print(solution(sushi, k, coupon))
