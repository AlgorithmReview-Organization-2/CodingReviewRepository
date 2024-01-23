# https://www.acmicpc.net/problem/1213

'''
1. 아이디어 :
    알파벳을 담는 배열(26)을 만들고 각 알파벳의 개수를 센다.
    빠른 알파벳부터 2씩 차감하면서 Answer에 추가하고,
    Palindrome 갯수에 따라, 짝수일때 배열의 합이 0이면 Answer + Answer[::-1]을 출력하고,
    홀수일때 배열의 합이 1이면 Answer + Palindrome + Answer[::-1]을 출력한다.
    합이 그 이상이면 "I'm Sorry Hansoo"를 출력한다.
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    배열
'''

string = input()
alpha = [0] * 26
for c in string:
    alpha[ord(c) - 65] += 1
ans = ""
for i in range(len(alpha)):
    ans += chr(i + 65) * (alpha[i] // 2)
    alpha[i] %= 2

if len(string) % 2 == 0:  # Even
    if sum(alpha) == 0:
        print(ans + ans[::-1])
    else:
        print("I'm Sorry Hansoo")
else:  # Odd
    if sum(alpha) == 1:
        print(ans + chr(alpha.index(1) + 65) + ans[::-1])
    else:
        print("I'm Sorry Hansoo")
