# https://www.acmicpc.net/problem/12891 DNA 비밀번호

'''
1. 아이디어 :
    슬라이딩 윈도우를 사용.
    조금 더 효율적으로 하기 위해 해시맵과 counts를 사용했다.
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    해시맵, 배열
'''
import sys

sys.setrecursionlimit(1000000)
input = sys.stdin.readline


def solution(length, string, hmap):
    counts = 0
    left_chars = 0
    for key, val in hmap.items():
        if val > 0:
            left_chars += 1
    left = 0
    for right in range(length):
        hmap[string[right]] -= 1
        if hmap[string[right]] == 0:
            left_chars -= 1

    right += 1
    if left_chars == 0:
        counts += 1

    while right < len(string):
        if hmap[string[left]] == 0:
            left_chars += 1
        hmap[string[left]] += 1

        hmap[string[right]] -= 1
        if hmap[string[right]] == 0:
            left_chars -= 1

        if left_chars == 0:
            counts += 1

        left += 1
        right += 1

    return counts


n, m = list(map(int, input().split()))
s = input().rstrip()
temp = [int(num) for num in input().split()]
char_list = {"A": temp[0], "C": temp[1], "G": temp[2], "T": temp[3]}
print(solution(m, s, char_list))
