# https://www.acmicpc.net/problem/1049

'''
1. 아이디어 :
    6개씩 패키지 가격으로, 1개씩 패키지 가격으로 구매하는 것 중 최소값을 구하면 된다.
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    배열
'''

n, m = map(int, input().split())
six = float('inf')
one = float('inf')
for _ in range(m):
    a, b = map(int, input().split())
    six = min(six, a)
    one = min(one, b)

ans = [one]
for i in range(1, n):
    ans.append(min(ans[i - 1] + one, six * ((i // 6) + 1)))
print(ans[-1])
