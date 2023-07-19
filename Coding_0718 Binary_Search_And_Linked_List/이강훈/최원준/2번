# https://www.acmicpc.net/problem/2512

'''
1. 아이디어 :
    1) 이분탐색
2. 시간복잡도 :
    1) O(nlogn)
3. 자료구조 :
    1) 배열
'''

n = int(input())
req = list(map(int, input().split()))
total = int(input())
left = 1
right = max(req)

if sum(req) < total:
    print(max(req))
    exit()


def check(money):
    count = 0
    for r in req:
        if r > money:
            count += money
        else:
            count += r
    return count


while left <= right:
    mid = (left + right) // 2

    temp = check(mid)
    if temp > total:
        right = mid - 1

    elif temp <= total:
        left = mid + 1
print(right)
