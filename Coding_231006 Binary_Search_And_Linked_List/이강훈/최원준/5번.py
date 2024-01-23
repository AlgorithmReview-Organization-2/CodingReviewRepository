# https://www.acmicpc.net/problem/1300

'''
1. 아이디어 :
    정렬로 하면 메모리 초과가 난다.
    이분탐색으로 k번째 숫자가 답이라 가정하고, 앞에 몇개의 숫자가 올 수 있는지 구하는 방식으로 하면된다.
2. 시간복잡도 :
    O(nlogn)
3. 자료구조 :
    배열
'''

n = int(input())
k = int(input())

start, end = 0, k

while start <= end:
    mid = (start+end)//2
    count = 0

    for i in range(1, n+1):
        count += min(mid//i, n)

    if count >= k:
        ans = mid
        end = mid - 1
    else:
        start = mid + 1
print(ans)
