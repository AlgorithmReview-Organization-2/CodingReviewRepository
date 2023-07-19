# https://www.acmicpc.net/problem/1654

'''
1. 아이디어 :
    1) 이분탐색
2. 시간복잡도 :
    1) O(k * logN)
3. 자료구조 :
    1) 배열
'''

k, n = map(int, input().split())
lines = [int(input()) for _ in range(k)]
left = 1
right = max(lines)


def check(length, n):
    count = 0
    for l in lines:
        count += l // length
    return True if count >= n else False


while left <= right:
    mid = (left + right) // 2
    if check(mid, n):
        left = mid + 1
    else:
        right = mid - 1

print(right)
