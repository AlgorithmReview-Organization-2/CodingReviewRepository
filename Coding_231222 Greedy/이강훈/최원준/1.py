# https://www.acmicpc.net/problem/1339

'''
1. 아이디어 :
    각 알파벳의 자리수만큼 값을 더한다 (ex. ABC = 100A + 10B + C)
    순서대로 정렬 한 후에, 큰 값부터 9부터 0까지 곱해준다.
2. 시간복잡도 :
    O(nlogn)
3. 자료구조 :
    배열
'''
import sys

input = sys.stdin.readline

letters = [input().rstrip() for _ in range(int(input()))]

alphabet_dict = {}
for letter in letters:
    for i in range(len(letter)):
        num = 10 ** (len(letter) - i - 1)
        if letter[i] not in alphabet_dict:
            alphabet_dict[letter[i]] = 0
        alphabet_dict[letter[i]] += num

scores = sorted([value for value in alphabet_dict.values()], reverse=True)

ans = 0
for i in range(len(scores)):
    ans += scores[i] * (9 - i)

print(ans)
