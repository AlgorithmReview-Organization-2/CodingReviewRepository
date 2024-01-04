# https://www.acmicpc.net/problem/16472

'''
1. 아이디어 :
    슬라이딩 윈도우, 해시맵, 카운트 사용
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    배열, 해시맵
'''
from collections import defaultdict
import sys

sys.setrecursionlimit(1000000)
input = sys.stdin.readline


def solution(counts, string):
    ans = 0
    left, right = 0, 1
    hmap = defaultdict(int)
    hmap[string[0]] += 1
    counts -= 1
    while right < len(string):
        if counts >= 0:
            hmap[string[right]] += 1
            if hmap[string[right]] == 1:
                counts -= 1
            right += 1
        else:
            hmap[string[left]] -= 1
            if hmap[string[left]] == 0:
                counts += 1
            left += 1
        if counts >= 0:
            ans = max(ans, right - left)
    return ans


n = int(input().rstrip())
s = input().rstrip()
print(solution(n, s))
