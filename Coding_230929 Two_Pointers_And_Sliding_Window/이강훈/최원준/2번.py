# https://www.acmicpc.net/problem/

'''
1. 아이디어 :
    dp 배열 두개를 이용한다.
2. 시간복잡도 :
    O(n) * 3
3. 자료구조 :
    배열
'''

n = int(input())
cmin = list(map(int, input().split()))
cmax = cmin.copy()
for i in range(n - 1):
    x, y, z = list(map(int, input().split()))
    cmin = [min(cmin[0], cmin[1]) + x, min(cmin) + y, min(cmin[1], cmin[2]) + z]
    cmax = [max(cmax[0], cmax[1]) + x, max(cmax) + y, max(cmax[1], cmax[2]) + z]
print(max(cmax), min(cmin))

