# https://www.acmicpc.net/problem/1644

'''
1. 아이디어 :
    슬라이딩 윈도우를 사용한다
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    배열
'''


def prime_list(start, end):
    sieve = [True] * end
    if start <= 0:
        start = 2
    m = int(end ** 0.5)
    for i in range(2, m + 1):
        if sieve[i]:
            for j in range(i + i, end, i):
                sieve[j] = False
    return [i for i in range(start, end) if sieve[i]]


n = int(input())
primes = prime_list(2, n + 1) + [0]

l, r, count = 0, 0, 0
total = primes[0]
while r < len(primes) - 1:
    if total < n:
        r += 1
        total += primes[r]
    elif total > n:
        total -= primes[l]
        l += 1
    else:
        r += 1
        total += primes[r]
        total -= primes[l]
        l += 1
        count += 1
print(count)
