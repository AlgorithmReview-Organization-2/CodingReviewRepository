# https://www.acmicpc.net/problem/11728

'''
1. 아이디어 :
    투포인터. 두 배열을 정렬하고, 순서대로 하나씩 ans에 넣는다.
    둘 중 하나라고 포인터가 넘어가면, 나머지 배열을 뒤에 붙인다.
2. 시간복잡도 :
    O(n+m)
3. 자료구조 :
    배열
'''

n, m = map(int, input().split())
alist = list(map(int, input().split()))
blist = list(map(int, input().split()))

alist.sort()
blist.sort()

ans, ap, bp = [], 0, 0

while ap < n and bp < m:
    if alist[ap] > blist[bp]:
        ans.append(blist[bp])
        bp += 1
    else:
        ans.append(alist[ap])
        ap += 1

if ap == n:
    ans.extend(blist[bp:])
else:
    ans.extend(alist[ap:])

print(' '.join(map(str, ans)))
